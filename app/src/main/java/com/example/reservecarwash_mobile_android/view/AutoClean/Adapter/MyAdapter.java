package com.example.reservecarwash_mobile_android.view.AutoClean.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.InfoFragment;
import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.VehiculeFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                InfoFragment infoFragment = new InfoFragment();
                return infoFragment;
            case 1:
                VehiculeFragment vehiculeFragment = new VehiculeFragment();
                return vehiculeFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
