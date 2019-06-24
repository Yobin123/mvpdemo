package com.example.hybss.mvpdemo.presenter.fragment;

import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContacts.IHomeFragmentView> implements HomeFragmentContacts.IHomePresenter {


    public HomeFragmentPresenter(HomeFragmentContacts.IHomeFragmentView view) {
        super(view);
    }
}
