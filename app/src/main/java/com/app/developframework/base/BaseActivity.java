package com.app.developframework.base;

import android.os.Bundle;

import com.app.developframework.utils.ToastUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
    }

    protected void myToast(String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(BaseActivity.this, str);
            }
        });
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

}
