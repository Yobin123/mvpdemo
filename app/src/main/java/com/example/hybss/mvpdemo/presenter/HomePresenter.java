package com.example.hybss.mvpdemo.presenter;

import com.example.hybss.mvpdemo.contract.HomeContacts;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

public class HomePresenter extends BasePresenter<HomeContacts.IHomeView> implements HomeContacts.IHomePresenter {

    public HomePresenter(HomeContacts.IHomeView view) {
        super(view);
    }


    @Override
    public void showHomeFragment() {
        if (isViewAttach())
            mvpRef.get().showFragmentTip(HomeContacts.HOME_PAGE);
    }

    @Override
    public void showNewsFragment() {
        if (isViewAttach())
            mvpRef.get().showFragmentTip(HomeContacts.NEWS_PAGE);
    }

    @Override
    public void showMeFragment() {
        if (isViewAttach())
            mvpRef.get().showFragmentTip(HomeContacts.ME_PAGE);
    }
}
