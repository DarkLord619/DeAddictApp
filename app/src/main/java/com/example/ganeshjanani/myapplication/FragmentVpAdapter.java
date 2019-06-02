package com.example.ganeshjanani.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentVpAdapter extends FragmentPagerAdapter {
    public FragmentVpAdapter(FragmentManager fm) {
        super(fm);
    }

    ArrayList<Fragment> mFragments= new ArrayList<>();
    public void addFragmets(){
        mFragments.add(new UsageFragment());
        mFragments.add(new NotificationFragment());
        mFragments.add(new PasswordFragment());



    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }





}
