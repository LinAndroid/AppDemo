package com.app.developframework.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.app.developframework.R;
import com.app.developframework.base.BaseDialog;

public class PermissionDialog extends BaseDialog {

    private TextView mBtnPermission;
    private onPermissionDialogListener mOnClickListener;

    public PermissionDialog(Context context) {
        super(context);
    }

    @Override
    protected float setWidthScale() {
        return 0.9f;
    }

    @Override
    protected AnimatorSet setEnterAnim() {
        return null;
    }

    @Override
    protected AnimatorSet setExitAnim() {
        return null;
    }

    @Override
    protected void init() {
        mBtnPermission = (TextView) findViewById(R.id.btn_permission);
        mBtnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener != null) {
                    dismiss();
                    mOnClickListener.onClick();
                }
            }
        });
    }

    public void setOnClickListener(onPermissionDialogListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public interface onPermissionDialogListener {
        void onClick();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.dialog_permission;
    }

}
