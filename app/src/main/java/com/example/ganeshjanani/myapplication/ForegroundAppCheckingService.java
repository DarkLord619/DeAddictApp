package com.example.ganeshjanani.myapplication;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.StrictMode;
import android.widget.Toast;

import com.rvalerio.fgchecker.AppChecker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;

public class ForegroundAppCheckingService extends Service {
    boolean StrictMode;
    Set selectedApps;
    long specifiedTime;
    AppChecker mAppChecker = new AppChecker() ;
    AppChecker mChecker= new AppChecker();
    long StartTime;
    boolean NotificationBlocked;
    List<String> SelectedApps;
    boolean tofinish;
    tabclass mAppclass= new tabclass();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service STarted",Toast.LENGTH_SHORT).show();
        final SharedPreferences appBlock=getSharedPreferences("AppBlock",0);
        final  SharedPreferences.Editor ed=appBlock.edit();
        StrictMode=appBlock.getBoolean("StrictMode",false);
        NotificationBlocked=appBlock.getBoolean("NotBlocked",false);
        specifiedTime=appBlock.getLong("SpecifiedTime",0);
        StartTime=appBlock.getLong("StartTime",0);
        selectedApps=appBlock.getStringSet("SelectedApps",null);
        SelectedApps= new ArrayList<>();
        mAppclass.disabletouch(getApplicationContext());
        SelectedApps.addAll(selectedApps);
        int start=SelectedApps.size();
        for(int k=start+1;k<=10;k++){
            SelectedApps.add(null);

        }

        System.out.println("SuperBowl"+SelectedApps);
        System.out.println(SelectedApps.get(1) + "SuperBowl");
        if(StrictMode){
            EnableStrictMode();
        }
        String app0=SelectedApps.get(0);
        String app1=SelectedApps.get(1);
        String app2=SelectedApps.get(2);
        String app3=SelectedApps.get(3);
        String app4=SelectedApps.get(4);
        String app9=SelectedApps.get(9);
        String app5=SelectedApps.get(5);
        String app6=SelectedApps.get(6);
        String app7=SelectedApps.get(7);
        String app8=SelectedApps.get(8);




        Intent i= new Intent(getApplicationContext(),AppBlockIntent.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //  i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        i.putExtra("startTime",StartTime);
        i.putExtra("UserTime",specifiedTime);
        i.putExtra("NotificationBlocked",NotificationBlocked);


          for(int ii=0;ii<SelectedApps.size();ii++){
              System.out.println("Einstein" + SelectedApps.get(ii));
          }
AppChecker appChecker= new AppChecker();
          appChecker.whenAny(new AppChecker.Listener() {
              @Override
              public void onForeground(String process) {
                  System.out.println("Matikita pangu" + process);
                  if(SelectedApps.contains(process)){

                  tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
                    i.putExtra("RemTime",remTime);
                    if(!tofinish)
                   // startActivity(i);
                    {
                        Intent intentt = new Intent(Intent.ACTION_MAIN);
                        intentt.addCategory(Intent.CATEGORY_HOME);
                        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentt);
                    }
                    else { disableStrictMode();
                    mAppclass.enabletouch(getApplicationContext());
                        appChecker.stop();
                    }
              }
              }
          }).timeout(1000).start(this);

          AppChecker myAppChecker=new AppChecker();
          myAppChecker.when("com.example.ganeshjanani.myapplication", new AppChecker.Listener() {
              @Override
              public void onForeground(String process) {
                  tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
                  //long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
                  //i.putExtra("RemTime",remTime);
                  if(!tofinish)
                  {
                      Intent intentt = new Intent(Intent.ACTION_MAIN);
                      intentt.addCategory(Intent.CATEGORY_HOME);
                      intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      startActivity(intentt);

                  }
                  else { disableStrictMode();
                      mAppclass.enabletouch(getApplicationContext());
                      myAppChecker.stop();
                  }

              }
          }).timeout(1000).start(this);

          //AppChecker appChecker1=new AppChecker();

//
//        final AppChecker appChecker= new AppChecker();
//
//            appChecker
//                    .whenAny(new AppChecker.Listener() {
//                        @Override
//                        public void onForeground(String process) {
//                            System.out.println("SuperBowl" + process );
//                        }
//                    }).timeout(1000).start(this);
//             appChecker       .when(app0, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                    startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when("com.google.android.youtube", new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app2, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(),"dont open  utube "  ,Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app3, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//                    .when(app4, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app5, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app6, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app7, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//                    .when(app8, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else {disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            })
//            .when(app9, new AppChecker.Listener() {
//                @Override
//                public void onForeground(String process) {
//                    Toast.makeText(getApplicationContext(),"Service STarted",Toast.LENGTH_SHORT).show();
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        appChecker.stop();
//                    }
//                }
//            }).timeout(1000).start(this);
//






        System.out.println("Dangal" + StrictMode);
        System.out.println("Dangal" + NotificationBlocked);
        System.out.println("Dangal" + specifiedTime);
        System.out.println("Dangal" + StartTime);
        System.out.println("Dangal" + SelectedApps);

        return START_STICKY;
    }

    public void EnableStrictMode() {

     mChecker.when("com.android.vending", new AppChecker.Listener() {
         @Override
         public void onForeground(String process) {
             Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
             Intent intentt = new Intent(Intent.ACTION_MAIN);
             intentt.addCategory(Intent.CATEGORY_HOME);
             intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             startActivity(intentt);
         }
     }).timeout(1000).start(this);
        mAppChecker.when("com.android.settings", new AppChecker.Listener() {
            @Override
            public void onForeground(String process) {
                Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                Intent intentt = new Intent(Intent.ACTION_MAIN);
                intentt.addCategory(Intent.CATEGORY_HOME);
                intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentt);
            }
        }).timeout(1000).start(this);


    }
    public void disableStrictMode(){
        mAppChecker.stop();
        mChecker.stop();



    }
}
