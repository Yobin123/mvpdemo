package com.example.hybss.mvpdemo.contract.fragment;

import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.listeners.ModuleCallback;
import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

import java.util.List;

//首页fragment相关页面
public class HomeFragmentContacts {

    public interface IHomeModule {
        void getWelfareData(int page, int size, ModuleCallback<List<WelfareBean>> callback);
    }

    public interface IHomePresenter extends IPresenter {
        void getWelfareData(int page, int size);
    }

    public interface IHomeFragmentView extends IView {
        void showData(List<WelfareBean> welfareBeanList);

        void onFailure(Throwable throwable); // 请求失败
    }
}
