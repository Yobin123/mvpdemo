package com.example.hybss.mvpdemo.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.activity.LoginContacts;
import com.example.hybss.mvpdemo.presenter.activity.LoginPresenter;
import com.example.hybss.mvpdemo.view.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContacts.IMain {
    private EditText et_username, et_password;
    private Button btn_login;

    @Override
    protected LoginPresenter bindPresenter() {
        return new LoginPresenter(this); //初始化相应的操作。
    }

    @Override
    protected int onLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        et_username = fv(R.id.et_username);
        et_password = fv(R.id.et_password);
        btn_login = fv(R.id.btn_login);
    }

    @Override
    protected void addListener() {
        btn_login.setOnClickListener(this);
    }

    @Override
    protected void setControl() {

    }

    @Override
    public void showTip(boolean isSuccess) {
        startActivity(new Intent(this, HomeActivity.class));
        if (isSuccess) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mvpPre.login(et_username.getText().toString().trim(), et_password.getText().toString().trim());
                break;
        }
    }
}
