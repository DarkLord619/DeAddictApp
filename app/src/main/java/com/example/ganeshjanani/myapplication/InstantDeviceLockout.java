//package com.example.ganeshjanani.myapplication;
//
//import android.app.admin.DevicePolicyManager;
//import android.content.BroadcastReceiver;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
//import android.os.PowerManager;
//import androidx.appcompat.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//
//public class InstantDeviceLockout extends AppCompatActivity {
//
//    DevicePolicyManager dpm;
//    PhoneUnlockedReceiver receiver;
//
//    BroadcastReceiver chargerReceiver;
//
//    boolean emerbtn = false;
//    boolean emerbtnno = false;
//
//    public boolean tofinish = false;
//    public long startTime;
//
//
////    @Override
////    protected void onDestroy() {
////        super.onDestroy();
////        unregisterReceiver(receiver);
////    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.usagedevicelocklayout);
//
//        final EditText editText = findViewById(R.id.editText2);
//        final CheckBox cb1 = findViewById(R.id.checkBox);
//        final CheckBox cb2 = findViewById(R.id.checkBox2);
//        final PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
//        final PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
//                | PowerManager.ACQUIRE_CAUSES_WAKEUP
//                | PowerManager.ON_AFTER_RELEASE, "INFO:");
//
//
//        dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
////
////        chargerReceiver
////                = new BroadcastReceiver()
////
////        {
////            @Override
////            public void onReceive(Context context, Intent intent) {
////                // TODO: Awesome things
////                Toast.makeText(context,"UNlocked",Toast.LENGTH_SHORT).show();
////                System.out.println("cmon");
////            }
////        };
////
////        registerReceiver(
////                chargerReceiver,
////                new IntentFilter(Intent.ACTION_USER_PRESENT)
////        );
//
//
//        receiver = new PhoneUnlockedReceiver();
//        //   IntentFilter i= new IntentFilter();
//        //    i.addAction(Intent.ACTION_USER_PRESENT);
//        // i.addAction(Intent.ACTION_SCREEN_OFF);
//        // i.addAction(Intent.ACTION_SCREEN_ON);
//        registerReceiver(receiver, new IntentFilter(Intent.ACTION_USER_PRESENT));
//
//
//        Button btn2 = findViewById(R.id.btndevicelock);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            long time;
//
//            @Override
//            public void onClick(View view) {
//                startTime = System.currentTimeMillis();
//                time = Long.parseLong((editText.getText().toString()));
//                emerbtn = cb1.isChecked();
//                emerbtnno = cb2.isChecked();
//                //receiver.PhoneUnlockedReceiverr(time, emerbtn, emerbtnno, startTime, pm);
//                System.out.println("Timee"+startTime);
//                 System.out.println("Timee"+time);
//                dpm.lockNow();
//
//
//            }
//        });
//
//    }
//}
