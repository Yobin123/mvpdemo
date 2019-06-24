package com.example.hybss.mvpdemo.contract.activity;

import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

/**
 * 创建一个契约类，便于管理相关类
 */
public final class MainContacts {
    public interface IMain extends IView {
        void showTip(boolean isSuccess); 
    }

    public interface IMainPre extends IPresenter {
        void login(String userName, String password);
    }

    public interface IMainLgc {
        boolean login(String userName, String password);
    }
}
