package com.app.developframework.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.developframework.R;
import com.app.developframework.base.BaseFragment;


public class CenterFragment extends BaseFragment {
    private View mRootView;
    private TextView mTitleTv;


    private static final String BUNDLE_KEY_TITLE = "key_title";
    private String mTitle;

    public static CenterFragment newInstance(String title) {
        CenterFragment centerFragment = new CenterFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_TITLE, title);
        centerFragment.setArguments(bundle);
        return centerFragment;
    }


    @Override
    protected void init() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getString(BUNDLE_KEY_TITLE, "");
        }
    }

    @Override
    protected View initView() {
        mRootView = View.inflate(getContext(), R.layout.fragment_test, null);
        mTitleTv = mRootView.findViewById(R.id.tv_fragment_test);
        mTitleTv.setText(mTitle);
        return mRootView;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
