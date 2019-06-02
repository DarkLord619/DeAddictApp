package com.example.ganeshjanani.myapplication;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.widget.Toast;

import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.rey.material.widget.SnackBar;
import com.rvalerio.fgchecker.AppChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class UsageService extends Service {
    boolean StrictMode;
    Set selectedApps;
    long specifiedTime;
    AppChecker mAppChecker = new AppChecker() ;
    AppChecker mChecker= new AppChecker();
    long StartTime;
    boolean NotificationBlocked;
    List<String> SelectedApps;
    boolean tofinish;
     AppChecker a1=new AppChecker();
     AppChecker a2=new AppChecker();
    static int spentTime0=0;
    static int spentTime1=0;
    static int spentTime2=0;
    static int spentTime3=0;
    static int spentTime4=0;
    AppChecker appchecher0=new AppChecker();
    AppChecker appchecher1=new AppChecker();
    AppChecker appchecher2=new AppChecker();
    AppChecker appchecher3=new AppChecker();
    AppChecker appchecher4=new AppChecker();

    String packageName;
    tabclass mAppclass= new tabclass();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Ronaldo"+ packageName);



        new CountDownTimer(86400, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                appchecher0.stop();
                appchecher1.stop();
                appchecher2.stop();
                appchecher3.stop();
                appchecher4.stop();
                disableStrictMode();
               // mTextField.setText("done!");
            }
        }.start();





        Toast.makeText(this,"Service STartedU",Toast.LENGTH_SHORT).show();
        final SharedPreferences appBlock=getSharedPreferences("AppBlock",0);
        final  SharedPreferences.Editor ed=appBlock.edit();
        StrictMode=appBlock.getBoolean("StrictMode",false);
        //NotificationBlocked=appBlock.getBoolean("NotBlocked",false);
        specifiedTime=appBlock.getLong("SpecifiedTime",0);
        long alertTime=specifiedTime-30;
        packageName=appBlock.getString("Package", null);
        StartTime=appBlock.getLong("StartTime",0);
        selectedApps=appBlock.getStringSet("SelectedApps",null);
        SelectedApps= new ArrayList<>();
        mAppclass.disabletouch(getApplicationContext());
        SelectedApps.addAll(selectedApps);
        int start=SelectedApps.size();
        for(int k=start+1;k<=5;k++){
            SelectedApps.add(null);

        }

        System.out.println("SuperBowl"+SelectedApps);
        System.out.println(SelectedApps.get(1) + "SuperBowl");
        System.out.println("Hazard" + StrictMode);
        if(StrictMode){
            System.out.println("Hazard  enabled");
            EnableStrictMode();
        }
        String app0=SelectedApps.get(0);
        String app1=SelectedApps.get(1);
        String app2=SelectedApps.get(2);
        String app3=SelectedApps.get(3);
        String app4=SelectedApps.get(4);
        //String app9=SelectedApps.get(9);
       // String app5=SelectedApps.get(5);
       /// String app6=SelectedApps.get(6);
       // String app7=SelectedApps.get(7);
       // String app8=SelectedApps.get(8);




        Intent i= new Intent(getApplicationContext(),AppBlockIntent.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //  i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        i.putExtra("startTime",StartTime);
        i.putExtra("UserTime",specifiedTime);
        i.putExtra("NotificationBlocked",NotificationBlocked);


        for(int ii=0;ii<SelectedApps.size();ii++){
            System.out.println("Einstein" + SelectedApps.get(ii));


        }

        System.out.println("Ron" + app0);
        System.out.println("Ron" + app1);
        System.out.println("Ron" + app2);
        System.out.println("Ron" + app3);
        System.out.println("Ron" + app4);
        System.out.println("Ronaldo" + specifiedTime);
        System.out.println("Ronaldo" + alertTime);


//        AppChecker appChecker= new AppChecker();
//        appChecker.whenAny(new AppChecker.Listener() {
//            @Override
//            public void onForeground(String process) {
//                System.out.println("Matikita pangu" + process);
//                if(SelectedApps.contains(process)){
//
//                    tofinish=(System.currentTimeMillis()-StartTime)>specifiedTime;
//                    long remTime=specifiedTime-(System.currentTimeMillis()-StartTime);
//                    i.putExtra("RemTime",remTime);
//                    if(!tofinish)
//                        startActivity(i);
//                    else { disableStrictMode();
//                        mAppclass.enabletouch(getApplicationContext());
//                        appChecker.stop();
//                    }
//                }
//            }
//        }).timeout(1000).start(this);
             appchecher0.when(app0, new AppChecker.Listener() {
                 @Override
                 public void onForeground(String process) {
                    // Toast.makeText(getApplicationContext(),process,Toast.LENGTH_SHORT).show();
                     spentTime0++;
                     System.out.println("Ronaldo" + spentTime0);
                     if(spentTime0>=specifiedTime){
                         Toast.makeText(getApplicationContext(),"There was a restriction right?",Toast.LENGTH_LONG).show();
                         Intent intentt = new Intent(Intent.ACTION_MAIN);
                         intentt.addCategory(Intent.CATEGORY_HOME);
                         intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                         startActivity(intentt);
                     }
                     if(spentTime0==alertTime) {

                         Toast.makeText(getApplicationContext(),"App is gonna be blocked soon",Toast.LENGTH_LONG).show();






                     }

                 }
             }).timeout(1000).start(this);

        appchecher1.when(app1, new AppChecker.Listener() {
            @Override
            public void onForeground(String process) {
                //Toast.makeText(getApplicationContext(),process,Toast.LENGTH_SHORT).show();
                spentTime1++;
                System.out.println("Ronaldo" + spentTime1);
                if(spentTime1>=specifiedTime){
                    Toast.makeText(getApplicationContext(),"Violation encountered",Toast.LENGTH_LONG).show();
                    Intent intentt = new Intent(Intent.ACTION_MAIN);
                    intentt.addCategory(Intent.CATEGORY_HOME);
                    intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentt);
                }
                if(spentTime1==alertTime) {

                   Toast.makeText(getApplicationContext(),"App is gonna be blocked soon",Toast.LENGTH_LONG).show();







                }
            }
        }).timeout(1000).start(this);

        appchecher2.when(app2, new AppChecker.Listener() {
            @Override
            public void onForeground(String process) {
               //// Toast.makeText(getApplicationContext(),process,Toast.LENGTH_SHORT).show();
                spentTime2++;
                System.out.println("Ronaldo" + spentTime2);
                if(spentTime0>=specifiedTime){
                    Toast.makeText(getApplicationContext(),"Dont Appuse ",Toast.LENGTH_LONG).show();
                    Intent intentt = new Intent(Intent.ACTION_MAIN);
                    intentt.addCategory(Intent.CATEGORY_HOME);
                    intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentt);
                }
                if(spentTime2==alertTime) {
                    Toast.makeText(getApplicationContext(),"App is gonna be blocked soon",Toast.LENGTH_LONG).show();






                }
            }
        }).timeout(1000).start(this);

        appchecher3.when(app3, new AppChecker.Listener() {

            @Override
            public void onForeground(String process) {
             //   Toast.makeText(getApplicationContext(),process,Toast.LENGTH_SHORT).show();
                spentTime3++;
                System.out.println("Ronaldo" + spentTime3);
                if(spentTime3>=specifiedTime){
                    Toast.makeText(getApplicationContext(),"I think we had an agreement",Toast.LENGTH_LONG).show();
                    Intent intentt = new Intent(Intent.ACTION_MAIN);
                    intentt.addCategory(Intent.CATEGORY_HOME);
                    intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentt);
                }
                if(spentTime3==alertTime) {

                    Toast.makeText(getApplicationContext(),"Apps is gonna be b",Toast.LENGTH_LONG).show();






                }
            }
        }).timeout(1000).start(this);


        appchecher4.when(app4, new AppChecker.Listener() {



            @Override
            public void onForeground(String process) {
                spentTime4++;
                System.out.println("Ronaldo" + spentTime4);
                if(spentTime4>=specifiedTime){
                    Toast.makeText(getApplicationContext(),"There was a restriction right?",Toast.LENGTH_LONG).show();
                    Intent intentt = new Intent(Intent.ACTION_MAIN);
                    intentt.addCategory(Intent.CATEGORY_HOME);
                    intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentt);
                }
                if(spentTime4==alertTime) {

                    Toast.makeText(getApplicationContext(),"spent 90% of time",Toast.LENGTH_LONG).show();






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

        System.out.println("Hazard working"  );
        a1.when("com.android.vending", new AppChecker.Listener() {
            @Override
            public void onForeground(String process) {
                Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                Intent intentt = new Intent(Intent.ACTION_MAIN);
                intentt.addCategory(Intent.CATEGORY_HOME);
                intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentt);
            }
        }).timeout(1000).start(this);
        a2.when("com.android.settings", new AppChecker.Listener() {
            @Override
            public void onForeground(String process) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
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
