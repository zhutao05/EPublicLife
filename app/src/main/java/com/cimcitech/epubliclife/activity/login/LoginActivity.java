package com.cimcitech.epubliclife.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.cimcitech.epubliclife.MainActivity;
import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.utils.StatusBarUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.phone_tv)
    EditText phoneTv;
    @Bind(R.id.password_tv)
    EditText passwordTv;
    @Bind(R.id.show_pwd_cb)
    CheckBox showPwdCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        showPwdCb.setOnCheckedChangeListener(new showPassword());
        StatusBarUtils.setWindowActionAlpha(this);
    }

    @OnClick(R.id.login_button)
    public void login() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @OnClick(R.id.forget_password_tv)
    public void forgetPwd() {
        startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
    }

    @OnClick(R.id.register_tv)
    public void register() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    class showPassword implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                passwordTv.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordTv.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
