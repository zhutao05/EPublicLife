package com.cimcitech.epubliclife.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.utils.StatusBarUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPwdActivity extends AppCompatActivity {

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
    @Bind(R.id.next_button)
    Button nextButton;
    @Bind(R.id.finish_tv)
    TextView finishTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);
        StatusBarUtils.setWindowActionAlpha(this);
    }

    @OnClick(R.id.next_button)
    public void next() {
        codeLayout.setVisibility(View.GONE);
        passwordLayout.setVisibility(View.VISIBLE);
        nextButton.setText("重置密码");
    }

    @OnClick(R.id.finish_tv)
    public void finishTv() {
        finish();
    }
}
