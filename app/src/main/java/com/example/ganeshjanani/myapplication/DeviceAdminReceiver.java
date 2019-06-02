package com.example.ganeshjanani.myapplication;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DeviceAdminReceiver extends android.app.admin.DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        System.out.println("OnEnabled method now ");
        super.onEnabled(context, intent);
        System.out.println("OnEnabled method now ");
        Toast.makeText(context, "Truiton's Device Admin is now enabled",
                Toast.LENGTH_SHORT).show();
    }
}
