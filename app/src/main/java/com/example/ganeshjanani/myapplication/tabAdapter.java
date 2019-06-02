package com.example.ganeshjanani.myapplication;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class tabAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mFragments= new ArrayList<>();
  ArrayList<String> title= new ArrayList<>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    public  void addFragments(Fragment frag, String title){
        mFragments.add(frag);
        this.title.add(title);



    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);


    }

    public tabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
