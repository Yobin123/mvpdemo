package com.example.hybss.mvpdemo.presenter.fragment;

import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.listeners.ModuleCallback;
import com.example.hybss.mvpdemo.module.HomeModuleImpl;
import com.example.hybss.mvpdemo.presenter.base.BasePresenter;

import java.util.List;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContacts.IHomeFragmentView> implements HomeFragmentContacts.IHomePresenter {
    private HomeModuleImpl homeModule;

    public HomeFragmentPresenter(HomeFragmentContacts.IHomeFragmentView view) {
        super(view);
        homeModule = new HomeModuleImpl();
    }

    @Override
    public void getWelfareData(int page, int size) {
        if (isViewAttach()) {
           homeModule.getWelfareData(page, size, new ModuleCallback<List<WelfareBean>>() {
               @Override
               public void getModuleData(List<WelfareBean> data) {
                   mvpRef.get().showData(data);
               }
           });
        }
    }

 
}
