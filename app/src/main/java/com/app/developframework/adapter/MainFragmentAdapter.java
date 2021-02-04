package com.app.developframework.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.app.developframework.base.BaseFragment;
import com.app.developframework.fragment.CenterFragment;
import com.app.developframework.fragment.HomeFragment;
import com.app.developframework.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private SparseArray<BaseFragment> mFragments = new SparseArray<>();
    private List<String> mTitles;

    public BaseFragment getSpecialFragment(int position) {
        return mFragments.get(position);
    }

    public MainFragmentAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.mTitles = titles;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        String title = mTitles.get(position);
        switch (position) {
            case 0:
                fragment = HomeFragment.newInstance(title);
                break;
            case 1:
                fragment = CenterFragment.newInstance(title);
                break;
            case 2:
                fragment = SettingFragment.newInstance(title);
        }
        return fragment;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BaseFragment fragment = (BaseFragment) super.instantiateItem(container, position);
        mFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }
}