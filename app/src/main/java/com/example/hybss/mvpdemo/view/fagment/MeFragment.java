package com.example.hybss.mvpdemo.view.fagment;

import android.view.View;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.fragment.MeFragmentContacts;
import com.example.hybss.mvpdemo.presenter.fragment.MeFragmentPresenter;
import com.example.hybss.mvpdemo.view.base.BaseFragment;

public class MeFragment extends BaseFragment<MeFragmentPresenter> implements MeFragmentContacts.IMeFragmentView {

    // TODO: Rename and change types and number of parameters
    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }


    @Override
    protected MeFragmentPresenter bindPresenter() {
        return new MeFragmentPresenter(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_me;
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
}
