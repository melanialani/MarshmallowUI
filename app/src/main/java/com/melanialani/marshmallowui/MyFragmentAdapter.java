package com.melanialani.marshmallowui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.melanialani.marshmallowui.Fragments.Fragment1;
import com.melanialani.marshmallowui.Fragments.Fragment2;

/**
 * Created by melan on 9/28/2016.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public MyFragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
