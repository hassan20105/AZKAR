package com.hisnElMuslem.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hisnElMuslem.myapplication.Model.ZekrItems;

import java.util.ArrayList;
import java.util.List;

public class FragmentCollectionAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> zekrItems;

    public FragmentCollectionAdapter(FragmentManager fm, ArrayList<String> zekrItems) {
        super(fm);
        this.zekrItems = zekrItems;
    }

    @Override
    public Fragment getItem(int position) {
        DynamicFragment dynamicFragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", zekrItems.get(position));
        dynamicFragment.setArguments(bundle);
        return dynamicFragment;
    }

    @Override
    public int getCount() {
        return zekrItems.size();
    }
}
