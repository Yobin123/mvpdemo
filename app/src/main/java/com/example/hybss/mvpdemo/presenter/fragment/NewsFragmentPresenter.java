package com.example.hybss.mvpdemo.presenter.fragment;

import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.contract.fragment.NewsFragmentContacts;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

public class NewsFragmentPresenter extends BasePresenter<NewsFragmentContacts.INewsFragmentView> implements NewsFragmentContacts.INewsFragmentPresenter {

    public NewsFragmentPresenter(NewsFragmentContacts.INewsFragmentView view) {
        super(view);
    }
}
