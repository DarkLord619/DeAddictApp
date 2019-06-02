package com.example.ganeshjanani.myapplication;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class UsageDeviceLockLayout extends AppCompatActivity {

    DevicePolicyManager dpm;



    PhoneUnlockedReceiver receiver;
    BootUpReceiver mBootUpReceiver;

    BroadcastReceiver chargerReceiver;
static  int attempts=4;
    boolean emerbtn = false;
    boolean emerbtnno = false;

    public boolean tofinish = false;
    public long startTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usagedevicelocklayout);
       final SharedPreferences device=getSharedPreferences("Device",0);
       final  SharedPreferences.Editor ed=device.edit();
       /*
   String[] time={"Seconds","Minutes","H"}
   ArrayAdapter<String> adapter= ArrayAdapter.createFromResource(getApplicationContext(),)
   */ List<String> time = new ArrayList<String>();
        time.add("Second(s)");
        time.add("Minute(s)");
        time.add("Hour(s)");
       // time.add("Day(s)");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, time);

        // Drop down layout style - list view with radio button

     final Spinner spinner=findViewById(R.id.spinner);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        final EditText editText = findViewById(R.id.editText2);
        final CheckBox cb1 = findViewById(R.id.checkBox);
        final CheckBox cb2 = findViewById(R.id.checkBox2);
        final PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        final PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
                | PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.ON_AFTER_RELEASE, "INFO:");


        dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        chargerReceiver
                = new BroadcastReceiver()

        {
            @Override
            public void onReceive(Context context, Intent intent) {
                // TODO: Awesome things

                System.out.println("Senthil Booted");
                Long time1=device.getLong("Time",0);
                Long startTime1=device.getLong("StartTime",619);
                boolean emerbtnn=device.getBoolean("E1",false);
                boolean emerbtnnno=device.getBoolean("E2",false);

//
//
//        System.out.println("Timee"+startTime);
//        System.out.println("Timee"+time);

//
////        pm=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
////        mWakeLock=pm.newWakeLock(PowerManager.FULL_WAKE_LOCK| PowerManager.ACQUIRE_CAUSES_WAKEUP| PowerManager.ON_AFTER_RELEASE,"INFO:");
//        System.out.println("tagg" + this.time);
//        System.out.println("tagg" + this.startTime);
//        System.out.println("tagg" + emerbtn);
//        System.out.println("tagg" + emerbtnno);

                boolean tofinsih=(System.currentTimeMillis()-startTime1)>time1;
                long remTime=time1-(System.currentTimeMillis()-startTime1);
//        System.out.println("Rem time" + remTime);
                if(emerbtnnno)
                    attempts--;
//        System.out.println("On receive calling when unlocked");
//        System.out.println(tofinsih);
//        System.out.println(startTime);
//        System.out.println(time);
                if(!tofinsih)
                {

                   // System.out.println("Unlocked");
                   // System.out.println(intent.getAction());
                    //Toast.makeText(context,"time not over",Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(context,devicelockintentclass.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //  i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    i.putExtra("startTime",startTime1);
                    i.putExtra("UserTime",time1);
                    i.putExtra("Emerbtn",emerbtnn);
                    i.putExtra("Emerbtnno",emerbtnnno);
                    i.putExtra("Attempts",attempts);
                    i.putExtra("RemTime",remTime);

                    context.startActivity(i);}
                else {
                    attempts=4;
                    Toast.makeText(context,"TimeElapsed",Toast.LENGTH_SHORT).show();

                    Intent myIntent = new Intent(context, tabclass.class);
                    myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(myIntent);
                    Intent intentt = new Intent(Intent.ACTION_MAIN);
                    intentt.addCategory(Intent.CATEGORY_HOME);
                    intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentt);

                    //  ((Activity)context).finish();

                }



            }
        };

        registerReceiver(
                chargerReceiver,
                new IntentFilter(Intent.ACTION_USER_PRESENT)
        );



        //   IntentFilter i= new IntentFilter();
        //    i.addAction(Intent.ACTION_USER_PRESENT);
        // i.addAction(Intent.ACTION_SCREEN_OFF);
        // i.addAction(Intent.ACTION_SCREEN_ON);
        receiver = new PhoneUnlockedReceiver(getApplicationContext());
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_USER_PRESENT));

        mBootUpReceiver= new BootUpReceiver();
        registerReceiver(mBootUpReceiver,new IntentFilter(Intent.ACTION_BOOT_COMPLETED));




        Button btn2 = findViewById(R.id.btndevicelock);
        btn2.setOnClickListener(new View.OnClickListener() {
            long time;

            @Override
            public void onClick(View view) {
                startTime = System.currentTimeMillis();ed.putLong("StartTime",startTime);
                switch(spinner.getSelectedItemPosition()){
                    case 0:Long tempSecTime=Long.parseLong(editText.getText().toString());time=tempSecTime*1000;ed.putLong("Time",time);break;
                    case 1:Long tempMinTime=Long.parseLong(editText.getText().toString());time=tempMinTime*60000;ed.putLong("Time",time);break;
                    case 2:Long tempHrTime=Long.parseLong(editText.getText().toString());Long ttime=tempHrTime*60;time=ttime*60000;ed.putLong("Time",time);break;
                    //case 3:Long tempDayTime=Long.parseLong(editText.getText().toString());time=tempDayTime*1000;break;
                }
                //time = Long.parseLong((editText.getText().toString()));
                emerbtn = cb1.isChecked();ed.putBoolean("E1",emerbtn);
                emerbtnno = cb2.isChecked();ed.putBoolean("E2",emerbtnno);
                ed.apply();
               // receiver.PhoneUnlockedReceiverr(time, emerbtn, emerbtnno, startTime, pm);
                //System.out.println(startTime);
                // System.out.println(time);
                dpm.lockNow();


            }
        });

    }
}
