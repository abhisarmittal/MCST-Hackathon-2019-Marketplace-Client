package org.mort11.marketplaceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;

    public PageAdapter(FragmentManager fragmentManager, Fragment... fragments) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = fragments;
        //
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (fragments[position].getClass().getSimpleName().equals("Sell")) {
            return "Sell";
        }else if (fragments[position].getClass().getSimpleName().equals("Buy")){
            return "Buy";
        }
        return fragments[position].getClass().getSimpleName();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
