package com.app.developframework.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.app.developframework.R;
import com.app.developframework.base.BaseActivity;
import com.app.developframework.utils.Tools;


public class SplashActivity extends BaseActivity {

    private Handler mHandler = new Handler();

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initData() {
        Log.e("test", "Test--ClassName--->" + this.getClass().getName());
        Log.e("test", "Test--HashKey----->" + Tools.getKeyHash(this));
        mHandler.postDelayed(myTimerRun, 3000);
    }

    Runnable myTimerRun = new Runnable() {
        @Override
        public void run() {
            gotoMainActivity();
        }
    };


    private void gotoMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null && myTimerRun != null) {
            mHandler.removeCallbacks(myTimerRun);
        }
    }

    @Override
    public void onBackPressed() {
//		super.onBackPressed();

    }

    @Override
    protected void initView() {

    }


}
