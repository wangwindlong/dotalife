package xyz.abcapp.dotalife.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.abcapp.dotalife.R;
import xyz.abcapp.dotalife.widget.jumpbean.JumpingBeans;


public class LoadingDialog extends Dialog {

    private TextView msg;
    private JumpingBeans jumpingBeans;

    public LoadingDialog(Context context, boolean cancelable,
                         OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public LoadingDialog(Context context, int theme, ViewGroup viewGroup) {
        super(context, theme);
        View view = LayoutInflater.from(context).inflate(R.layout.progress, viewGroup);
        msg = (TextView) view.findViewById(R.id.tv_loading_msg);

        setContentView(view);
        setCanceledOnTouchOutside(false);
    }

    @Override
    public void show() {
        super.show();
        jumpingBeans = JumpingBeans.with(msg)
                .appendJumpingDots()
                .build();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (jumpingBeans != null)
            jumpingBeans.stopJumping();
    }

    public LoadingDialog(Context context) {
        super(context);
    }


    public void setMessage(String message) {
        msg.setText(message);
    }

}