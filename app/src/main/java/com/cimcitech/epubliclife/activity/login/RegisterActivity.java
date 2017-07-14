package com.cimcitech.epubliclife.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.utils.StatusBarUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.phone_tv)
    EditText phoneTv;
    @Bind(R.id.code_tv)
    EditText codeTv;
    @Bind(R.id.code_bt)
    Button codeBt;
    @Bind(R.id.code_layout)
    LinearLayout codeLayout;
    @Bind(R.id.password_tv)
    EditText passwordTv;
    @Bind(R.id.new_password_tv)
    EditText newPasswordTv;
    @Bind(R.id.password_layout)
    LinearLayout passwordLayout;
    @Bind(R.id.show_pwd_cb)
    CheckBox showPwdCb;
    @Bind(R.id.next_button)
    Button nextButton;
    @Bind(R.id.finish_tv)
    TextView finishTv;
    @Bind(R.id.protocol_tv)
    TextView protocolTv;
    @Bind(R.id.protocol_layout)
    LinearLayout protocolLayout;
    @Bind(R.id.success_layout)
    RelativeLayout successLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        StatusBarUtils.setWindowActionAlpha(this);
    }

    @OnClick(R.id.next_button)
    public void next() {
        if (nextButton.getText().equals("下一步")) {
            codeLayout.setVisibility(View.GONE);
            passwordLayout.setVisibility(View.VISIBLE);
            nextButton.setText("注册");
            protocolLayout.setVisibility(View.INVISIBLE);
        } else if (nextButton.getText().equals("注册")) {
            codeLayout.setVisibility(View.GONE);
            passwordLayout.setVisibility(View.GONE);
            successLayout.setVisibility(View.VISIBLE);
            showPwdCb.setVisibility(View.INVISIBLE);
            finishTv.setVisibility(View.INVISIBLE);
            nextButton.setText("去登录");
        } else {
            finish();
        }
    }

    @OnClick(R.id.finish_tv)
    public void finishTv() {
        finish();
    }

    @OnClick(R.id.protocol_tv)
    public void protocolTv() {
        startActivity(new Intent(RegisterActivity.this, ProtocolActivity.class));
    }
}
