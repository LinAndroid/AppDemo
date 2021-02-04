package com.app.developframework.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.developframework.R;
import com.app.developframework.base.BaseDialog;



public class ExitDialog extends BaseDialog {

    private TextView yesTv;
    private TextView noTv;

    private LinearLayout rootView;
    private LinearLayout adRoot;

    public ExitDialog(Context context) {
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
    protected int getContentViewId() {
        return R.layout.dialog_exit;
    }




    private ExitListener exitListener;
    public void setExitListener(ExitListener exitListener){
        this.exitListener = exitListener;
    }

    @Override
    protected void init() {
        rootView = findViewById(R.id.ll_exit_dialog);
        adRoot = findViewById(R.id.ll_ad);
        yesTv = findViewById(R.id.tv_yes);
        noTv = findViewById(R.id.tv_no);

        yesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
                if(exitListener!=null){
                    exitListener.onClickYes();
                }

            }
        });

        noTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
                if(exitListener!=null){
                    exitListener.onClickNo();
                }
            }
        });
    }

    public interface ExitListener {
        void onClickYes();
        void onClickNo();
    }
}
