package com.app.developframework.activity;

import android.content.Intent;
import android.view.KeyEvent;

import com.app.developframework.R;
import com.app.developframework.adapter.MainFragmentAdapter;
import com.app.developframework.base.BaseActivity;
import com.app.developframework.bean.CustomBotTabItem;
import com.app.developframework.view.ExitDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> titles = new ArrayList<String>(Arrays.asList(getString(R.string.home), getString(R.string.center), getString(R.string.setting)));

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.id_tab_layout);
        mViewPager = findViewById(R.id.id_vp);


        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), titles));
        mTabLayout.setupWithViewPager(mViewPager);

        CustomBotTabItem item = CustomBotTabItem.create();
        item.setContext(this)
                .setViewPager(mViewPager)
                .setTabLayout(mTabLayout)
                .setTitles(titles)
                .build();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showExitDialog() {
        ExitDialog exitDialog = new ExitDialog(this);
        exitDialog.setExitListener(new ExitDialog.ExitListener() {
            @Override
            public void onClickYes() {
                finish();
            }

            @Override
            public void onClickNo() {
            }
        });
        exitDialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
