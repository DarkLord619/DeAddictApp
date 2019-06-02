package com.example.ganeshjanani.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class tabclass extends AppCompatActivity {
    Window mWindow;
    Context mActivity;
    public void disabletouch(Context context){
//        if( mActivity==null)
//            System.out.println("Messi");
//        else
//            System.out.println("Messsiah");
//        ((Activity)mActivity).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
//                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        }
        public void enabletouch(Context context){
           // mWindow.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationlayout);

mActivity=getApplicationContext();
        TabLayout tl= findViewById(R.id.tabLayout);
        ViewPager vp= findViewById(R.id.viewPager3);
        mWindow=getWindow();
        tabAdapter tb= new tabAdapter(getSupportFragmentManager());
        tb.addFragments(new deviceclass(),"Device Lock");
       tb.addFragments(new appclass(),"App Block");
       vp.setAdapter(tb);
       tl.setupWithViewPager(vp);

        DrawerLayout dl= findViewById(R.id.drawerlayout);
        NavigationView nv= findViewById(R.id.navheader);
       // ActionBarDrawerToggle adc= new ActionBarDrawerToggle(this, dl,getSupportActionBar().hide();)
        dl.openDrawer(Gravity.LEFT);


    }

    public static class FragmentSlideAdapter extends FragmentPagerAdapter {


        ArrayList<Fragment> mFragments= new ArrayList<>();

        public void addFragments(){

            mFragments.add(new UsageFragment());
            mFragments.add(new NotificationFragment());
            mFragments.add(new PasswordFragment());


        }


        @Override
        public Fragment getItem(int position) {
            return null;
        }

        public FragmentSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 0;
        }






    }
}
