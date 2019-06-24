package com.example.hybss.mvpdemo.module;

import android.text.TextUtils;

import com.example.hybss.mvpdemo.contract.activity.MainContacts;

public class MainLogic implements MainContacts.IMainLgc {
    @Override
    public boolean login(String userName, String password) { //这里做接口的请求，或者其他功能。
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }
}
