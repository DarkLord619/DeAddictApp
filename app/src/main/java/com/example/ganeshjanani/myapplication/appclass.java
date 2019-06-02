package com.example.ganeshjanani.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;

public class appclass extends Fragment  {
    public Activity mActivity;
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.bottomappbarmenu,menu);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    final   View v=inflater.inflate(R.layout.appblocklayout,container,false);
    mActivity=getActivity();
        SharedPreferences appblock= getContext().getSharedPreferences("AppBlock",0);
        final SharedPreferences.Editor editor=appblock.edit();
        editor.putBoolean("StrictMode",false);
        editor.apply();
        BottomAppBar bottomAppBar= v.findViewById(R.id.bottomAppBar);
        final TextView mode=v.findViewById(R.id.textView17);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(bottomAppBar);
        bottomAppBar.replaceMenu(R.menu.bottomappbarmenu);
        FloatingActionButton floatingActionButton=v.findViewById(R.id.strictbtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        new BottomDialog.Builder(getContext())
                        .setTitle("Strict Mode")
                        .setContent("• Blocks access to Device Settings \n" +
                                "• Blocks Access to Play Store \n" +
                                "            \n"+
                                "           \n" +
                                 "NOTE: Strict Mode can be disabled anytime when no blocks are active."          )


                        .setPositiveText("ACTIVATE")
                        .setPositiveBackgroundColorResource(R.color.yellow)
                        //.setPositiveBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary)
                        .setPositiveTextColorResource(android.R.color.white)
                                .setNegativeText("DEACTIVATE")

                                .setNegativeTextColorResource(R.color.colorAccent)
                                //.setNegativeTextColor(ContextCompat.getColor(this, R.color.colorAccent)
                                .onNegative(new BottomDialog.ButtonCallback() {
                                    @Override
                                    public void onClick(BottomDialog dialog) {
                                        Toast.makeText(getContext(),"Strict Mode Disabled",Toast.LENGTH_SHORT).show();
                                        editor.putBoolean("StrictMode",false);
                                        editor.apply();
                                        mode.setText("DISABLED");
                                        mode.setTextColor(getResources().getColor(R.color.colorAccent,null));

                                    }
                                })
                        //.setPositiveTextColor(ContextCompat.getColor(this, android.R.color.colorPrimary)
                        .onPositive(new BottomDialog.ButtonCallback() {
                            @Override
                            public void onClick(BottomDialog dialog) {
                                Toast.makeText(getContext(),"Strict Mode Enabled",Toast.LENGTH_SHORT).show();
                                editor.putBoolean("StrictMode",true);
                                editor.apply();
                                mode.setText("ENABLED");
                                mode.setTextColor(getResources().getColor(R.color.green,null));

                            }

                        }).show();
            }
        });

        FrameLayout frameLayout= v.findViewById(R.id.framelayout);
        getFragmentManager().beginTransaction().add(R.id.framelayout,new instantappblock()).commit();
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout,new instantappblock()).commit();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle actions based on the menu item
                switch (item.getItemId()){
                    case R.id.usage: getFragmentManager().beginTransaction().replace(R.id.framelayout,new usageappblock()).commit();

                }
                return true;
            }
        });
    // MaterialFancyButton btn = v.findViewById(R.id.btn_preview);
       // btn.setText("Instant Block");
        //btn.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
               // Toast.makeText(getContext(),"Dammit",Toast.LENGTH_LONG).show();
               // Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
               // mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
               // List<ResolveInfo> pkgAppsList = getContext().getPackageManager().queryIntentActivities( mainIntent, 0);
                //Log.d("Listtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt",pkgAppsList.toString());
           // }
      //  });
        return v;
    }


}
