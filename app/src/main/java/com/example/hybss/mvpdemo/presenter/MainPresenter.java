package com.example.hybss.mvpdemo.presenter;

import com.example.hybss.mvpdemo.contract.MainContacts;
import com.example.hybss.mvpdemo.moudule.MainLogic;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContacts.IMain> implements MainContacts.IMainPre { //必须去继承baseFragment,实现锲约中的presenter类
    private MainLogic mMainLogc; // module类

    public MainPresenter(MainContacts.IMain view) {
        super(view);
        this.mMainLogc = new MainLogic(); //初始化相应的module类。
    }

    @Override
    public void login(String userName, String password) {
        //判断activity是否结束，不判断的化在极端情况可能出现内存泄漏
        if (isViewAttach()) {
            mvpRef.get().showTip(mMainLogc.login(userName, password));
        }
    }
}
