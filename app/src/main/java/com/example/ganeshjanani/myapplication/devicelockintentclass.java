package com.example.ganeshjanani.myapplication;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cn.iwgang.countdownview.CountdownView;

public class devicelockintentclass extends AppCompatActivity {

    DevicePolicyManager dpm;
    //static   int attempts;
    boolean allow=true;
    boolean emerbtn;
    boolean emerbtnno;
//    @Override
//    protected void onUserLeaveHint() {
//        dpm.lockNow();
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(allow)
            dpm.lockNow();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus && allow)
            dpm.lockNow();
        else
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deviceblockintent);
        final  int attempts;
        CountdownView cd=findViewById(R.id.cd);
      final int[] imgarray={R.drawable.i1,R.drawable.i2,
              R.drawable.i3,
              R.drawable.i4,
              R.drawable.i5,
              R.drawable.i6,
              R.drawable.i7,
              R.drawable.i8,
              R.drawable.i9,R.drawable.i10,
              R.drawable.i11,
              R.drawable.i12,
              R.drawable.i13,
              R.drawable.i14,
              R.drawable.i15,
              R.drawable.i16,
              R.drawable.i17,

      };
        dpm=(DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        Intent i=getIntent();
        long remTime=i.getLongExtra("RemTime",5);
        //attempts=i.getIntExtra("Attempts",0);
//        UserSpecifiedTime=i.getLongExtra("UserTime",0);
//        startTime=i.getLongExtra("startTime",0);
        cd.start(remTime);
        ImageView img= findViewById(R.id.imageView11);
        img.setImageResource(imgarray[new Random().nextInt(15)]);
        cd.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
            cv.stop();
            Toast.makeText(getApplicationContext(),"Go Back And Unlock Now",Toast.LENGTH_LONG).show();
            }
        });
        attempts=i.getIntExtra("Attempts",0);
        System.out.println("attempts " + attempts);
        emerbtn=i.getBooleanExtra("Emerbtn",false);
        emerbtnno=i.getBooleanExtra("Emerbtnno",false);
        Button btn=findViewById(R.id.button3);
        System.out.println("attempts btn1" + emerbtn);
        System.out.println("attempts btn2 " + emerbtnno);
        do{
            System.out.println("attempts DO BLOCK EXECUTING");
            if(emerbtn && attempts>0){
                System.out.println("attempts if block executed");
                btn.setVisibility(View.VISIBLE);}
            else{System.out.println("else block executed");
                btn.setVisibility(View.INVISIBLE);}}while(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // attempts--;

                System.out.println("attempts " + attempts);
                allow=false;
                final Timer timer= new Timer();
                TimerTask task= new TimerTask() {
                    int count=0;
                    @Override
                    public void run() {
                        if(count!=0){

                            dpm.lockNow();
                            System.out.println("attempts dpm is locking now");
                            timer.cancel();
                            finish();
                            System.out.println("attempts activity finished");}
                        else{

                            count++;
                        }
                    }
                };
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//               Intent intent = new Intent(Intent.ACTION_MAIN);
//               intent.addCategory(Intent.CATEGORY_HOME);
//               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//               startActivity(intent);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                // intent.setData(Uri.parse("tel:0123456789"));
                startActivity(intent);
                timer.schedule(task,1000,1000);


            }
        });






    }
}





