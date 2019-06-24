package com.example.hybss.mvpdemo.view.fagment;

import android.view.View;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.fragment.NewsFragmentContacts;
import com.example.hybss.mvpdemo.presenter.fragment.NewsFragmentPresenter;
import com.example.hybss.mvpdemo.view.base.BaseFragment;


public class NewFragment extends BaseFragment<NewsFragmentPresenter> implements NewsFragmentContacts.INewsFragmentView {

    @Override
    protected NewsFragmentPresenter bindPresenter() {
        return new NewsFragmentPresenter(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void setControl() {

    }

    @Override
    public void onClick(View v) {

    }

    public static NewFragment newInstance() {
        NewFragment fragment = new NewFragment();
        return fragment;
    }

}
