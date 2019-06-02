package com.example.ganeshjanani.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.widget.Toast;

public class PhoneUnlockedReceiver extends BroadcastReceiver {

    static long time;
    static boolean emerbtn;
    static boolean emerbtnno;
    static long startTime;
    static  boolean tofinsih;
    static int attempts=4;

//
//    PowerManager pm;
//    PowerManager.WakeLock mWakeLock;

    public PhoneUnlockedReceiver() {
    }

    public  PhoneUnlockedReceiver(Context context) {
        //System.out.println("tag" + time);
//        System.out.println("tag" + startTime);
//
//        System.out.println("tagg" + this.time);
//        System.out.println("tagg" + this.startTime);
//        System.out.println("tagg" + emerbtn);
//        System.out.println("tagg" + emerbtnno);
//
////
////        this.time = time;
//        this.emerbtn = (emerbtn);
//        this.emerbtnno = (emerbtnno);
//        this.startTime = startTime;
//        System.out.println("tag" + this.time);
//        System.out.println("tag" + this.startTime);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Koundamani BootedUp");
        final SharedPreferences device=context.getSharedPreferences("Device",0);
        final  SharedPreferences.Editor ed=device.edit();
        time=device.getLong("Time",0);
        startTime=device.getLong("StartTime",619);
        emerbtn=device.getBoolean("E1",false);
        emerbtnno=device.getBoolean("E2",false);

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

      tofinsih=(System.currentTimeMillis()-startTime)>time;
       long remTime=time-(System.currentTimeMillis()-startTime);
//        System.out.println("Rem time" + remTime);
        if(emerbtnno)
            attempts--;
//        System.out.println("On receive calling when unlocked");
//        System.out.println(tofinsih);
//        System.out.println(startTime);
//        System.out.println(time);
        if(!tofinsih)
        {

            System.out.println("Unlocked");
            System.out.println(intent.getAction());
            //Toast.makeText(context,"time not over",Toast.LENGTH_SHORT).show();
            Intent i= new Intent(context,devicelockintentclass.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //  i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            i.putExtra("startTime",startTime);
            i.putExtra("UserTime",time);
            i.putExtra("Emerbtn",emerbtn);
            i.putExtra("Emerbtnno",emerbtnno);
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



}
