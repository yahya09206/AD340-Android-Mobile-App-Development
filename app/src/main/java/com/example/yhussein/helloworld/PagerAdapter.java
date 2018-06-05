package com.example.yhussein.helloworld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter{

    private int tabsCount;

    PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabsCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProfileFragment();
            case 1:
                return new MatchesFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsCount;
    }
}
