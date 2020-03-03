package com.example.customdialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class MyCustomDialog extends DialogFragment {


    private View.OnClickListener yesListener;
    private View.OnClickListener noListener;

    private String message;
    private String title;
    private String txt_info;
    private String txt_btn_no;
    private String txt_btn_yes;

    private boolean btnNoVisible;
    private boolean btnYesVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog, container);

        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).requestFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView textView = view.findViewById(R.id.title_dialog);
        if (title != null && !title.isEmpty())
            textView.setText(title);

        TextView textViewMsg = view.findViewById(R.id.message_dialog);
        if (message != null && !message.isEmpty())
            textViewMsg.setText(message);
        else  textViewMsg.setVisibility(View.GONE);

        TextView textViewBtnYes= view.findViewById(R.id.txt_yes);
        textViewBtnYes.setOnClickListener(yesListener);
        if (txt_btn_yes != null && !txt_btn_yes.isEmpty())
            textViewBtnYes.setText(txt_btn_yes);

        TextView textViewBtnNo = view.findViewById(R.id.txt_cancel);
        textViewBtnNo.setOnClickListener(noListener);
        if (txt_btn_no != null && !txt_btn_no.isEmpty())
            textViewBtnNo.setText(txt_btn_no);

        TextView textViewInfo = view.findViewById(R.id.info_dialog);
        if (txt_info != null && !txt_info.isEmpty())
            textViewInfo.setText(txt_info);

        setCancelable(false);

        return view;
    }

    public void setBtnNoVisible(boolean visible) {
        this.btnNoVisible = visible;
    }

    public void setBtnYesVisible(boolean btnYesVisible) {
        this.btnYesVisible = btnYesVisible;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitleBtnYes(String txt) {
        this.txt_btn_yes = txt;
    }

    public void setTitleBtnNo(String txt) {
        this.txt_btn_no = txt;
    }

    public void setNoListener(View.OnClickListener noListener) {
        this.noListener = noListener;
    }

    public void setYesListener(View.OnClickListener yesListener) {
        this.yesListener = yesListener;
    }

    public void setInfo(String info) {
        this.txt_info= info;
    }

}
