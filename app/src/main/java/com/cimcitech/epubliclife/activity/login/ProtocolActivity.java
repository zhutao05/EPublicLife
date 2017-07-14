package com.cimcitech.epubliclife.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.utils.StatusBarUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户使用协议
 */
public class ProtocolActivity extends AppCompatActivity {

    @Bind(R.id.back_ib)
    ImageButton backIb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);
        ButterKnife.bind(this);
        StatusBarUtils.setWindowActionAlpha(this);
    }

    @OnClick(R.id.back_ib)
    public void backAt() {
        finish();
    }
}
