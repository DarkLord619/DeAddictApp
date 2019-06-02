package com.example.ganeshjanani.myapplication;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context,"BootedUp",Toast.LENGTH_LONG).show();
       System.out.println("BootedUp");
//        DevicePolicyManager dpm= (DevicePolicyManager)context.getSystemService(Context.DEVICE_POLICY_SERVICE);
//        dpm.lockNow();
        System.out.println("BootedUp"+intent.getAction());
        Intent i=new Intent(context,UsageDeviceLockLayout.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        DevicePolicyManager dpm= (DevicePolicyManager)context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        dpm.lockNow();

    }
}
