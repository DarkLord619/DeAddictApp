package com.example.ganeshjanani.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.github.clans.fab.FloatingActionButton;

public class deviceclass extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.devicelayout,container,false);
        FloatingActionButton fab=v.findViewById(R.id.menu_item);
        Button btn=v.findViewById(R.id.uninstallbtn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.DeviceAdminSettings")));
            }
        });

       // FloatingActionButton fab1=v.findViewById(R.id.menu_item2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getContext(),"Workng",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getContext(),UsageDeviceLockLayout.class);
                startActivity(i);

            }
        });

//        fab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getContext(),"Workng",Toast.LENGTH_SHORT).show();
//                Intent i=new Intent(getContext(),ProfileDeviceLockLayout.class);
//                startActivity(i);
//
//
//            }
      //  });









        return v;


    }

}
