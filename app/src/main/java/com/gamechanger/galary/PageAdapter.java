package com.gamechanger.galary;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabcount;
    public PageAdapter(@NonNull FragmentManager fm, Integer tabcount) {
        super(fm);
        this.tabcount=tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();
            case 4:
                return new Tab5();
            case 5:
                return new Tab6();
            case 6:
                return new Tab7();
            case 7:
                return new Tab8();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
