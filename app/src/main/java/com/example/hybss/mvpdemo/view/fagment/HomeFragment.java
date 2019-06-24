package com.example.hybss.mvpdemo.view.fagment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.presenter.fragment.HomeFragmentPresenter;
import com.example.hybss.mvpdemo.view.base.BaseFragment;


public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements HomeFragmentContacts.IHomeFragmentView {

    private Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity(); // 获取上下文
    }

    @Override
    protected HomeFragmentPresenter bindPresenter() {
        return new HomeFragmentPresenter(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

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
}
