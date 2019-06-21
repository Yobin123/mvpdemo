package com.example.hybss.mvpdemo.contract;

import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

public class HomeContacts {

    public static final String HOME_PAGE = "home";
    public static final String NEWS_PAGE = "news";
    public static final String ME_PAGE = "me";

    public interface IHomeView extends IView {
        void showFragmentTip(String tag); //进行点击后的显示
    }

    public interface IHomePresenter extends IPresenter {
        void showHomeFragment();

        void showNewsFragment();

        void showMeFragment();
    }

}
