package com.example.ganeshjanani.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;
import com.androidbuts.multispinnerfilter.SpinnerListener;
import com.ramotion.fluidslider.FluidSlider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class instantappblock extends Fragment {
    ArrayList<String> selectedapps;
    @Nullable
    @Override
    @SuppressWarnings("Convert2Lambda")

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.instantappblock,container,false);
        SharedPreferences appblock= getContext().getSharedPreferences("AppBlock",0);
        final SharedPreferences.Editor editor=appblock.edit();
        Button limitdistraction= view.findViewById(R.id.limitdisbtn);
   //     CheckBox notificationcheckbox=view.findViewById(R.id.blocknotchechbox);
        selectedapps= new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            selectedapps.add(null);
        }
            final PackageManager packageManager=getActivity().getPackageManager();
       final List<String> list = new ArrayList<>();
        final List<ApplicationInfo> packages = packageManager.getInstalledApplications(0);
        MultiSpinnerSearch searchMultiSpinnerLimit = view.findViewById(R.id.searchMultiSpinnerLimit);
        for (ApplicationInfo packageInfo : packages) {
            //System.out.println("hello");
            // System.out.println("MSGG" + packageInfo.loadLabel(packageManager));
            list.add(packageInfo.loadLabel(packageManager).toString());
            //  Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
            // Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));
        }


        final List<KeyPairBoolData> listArray1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray1.add(h);
        }
        searchMultiSpinnerLimit.setItems(listArray1, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {
                  int j=0;
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        for(ApplicationInfo packageInfo:packages){
                            if(items.get(i).getName().equals(packageInfo.loadLabel(packageManager))){
                                 selectedapps.set(j,packageInfo.packageName);
                                 j++;

                            }

                        }

                    }
                }
            }

        });



        searchMultiSpinnerLimit.setLimit(10, new MultiSpinnerSearch.LimitExceedListener() {
            @Override
            public void onLimitListener(KeyPairBoolData data) {
                Toast.makeText(getContext(),
                        "Limit exceed. Only 10 apps allowed for now", Toast.LENGTH_LONG).show();
            }
        });

        final int max = 23;
        final int min = 0;
        final int total = max - min;

        final int max1 = 59;
        final int min1= 0;
        final int total1 = max - min;
     final FluidSlider fluidSlider=view.findViewById(R.id.fluidSlider1);
     final FluidSlider fluidSlider1=view.findViewById(R.id.fluidSlider2);
     fluidSlider.setBubbleText("12");
     fluidSlider1.setBubbleText("30");
        fluidSlider.setBeginTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {

               // System.out.println("value" + fluidSlider.getBubbleText());
                return Unit.INSTANCE;
            }
        });
        fluidSlider.setPositionListener(pos -> {
            final String value = String.valueOf( (int)((1 - pos) * 23) );
            fluidSlider.setBubbleText(value);
            //System.out.println("value" + fluidSlider.getBubbleText());
            return Unit.INSTANCE;

        });
        fluidSlider1.setPositionListener(pos -> {
            final String value = String.valueOf( (int)((1 - pos) * 59) );
            System.out.println("Selected Apps" + selectedapps);
            fluidSlider1.setBubbleText(value);
            //System.out.println("value" + fluidSlider.getBubbleText());
            return Unit.INSTANCE;

        });

        limitdistraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<String> appset= new HashSet();
                for(String name:selectedapps){
                    System.out.println("Button   " + name);
                    appset.add(name);

                }
                editor.putStringSet("SelectedApps",appset);
                System.out.println("Button" + selectedapps );
                System.out.println("Button" + appset);
                editor.putLong("StartTime",System.currentTimeMillis());
                long hr= Long.parseLong(fluidSlider.getBubbleText());hr=hr*3600000;
                long min=Long.parseLong(fluidSlider1.getBubbleText());min=min*60000;
                editor.putLong("SpecifiedTime",hr+min);
              //  editor.putBoolean("NotBloked",notificationcheckbox.isSelected());
                editor.apply();

              getActivity().startService(new Intent(getContext(),ForegroundAppCheckingService.class));
            }
        });

        return view;
    }

}
