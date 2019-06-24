package com.example.hybss.mvpdemo.presenter.fragment;

import com.example.hybss.mvpdemo.contract.fragment.MeFragmentContacts;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

public class MeFragmentPresenter extends BasePresenter<MeFragmentContacts.IMeFragmentView> implements MeFragmentContacts.IMeFragmentPresenter {

    public MeFragmentPresenter(MeFragmentContacts.IMeFragmentView view) {
        super(view);
    }
}
