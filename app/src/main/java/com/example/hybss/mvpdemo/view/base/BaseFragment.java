package com.example.hybss.mvpdemo.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView, View.OnClickListener {

    //presenter对象
    protected P mvpPre;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPre = bindPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId(),container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        addListener();
        setControl();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 抽象方法    start
    ///////////////////////////////////////////////////////////////////////////
    protected abstract P bindPresenter();

    protected abstract int  layoutId(); //进行资源

    protected  abstract void  initView(); //进行初始化相关控件

    protected abstract void  addListener(); // 进行控件添加

    protected abstract void  setControl(); //添加主逻辑代码

    ///////////////////////////////////////////////////////////////////////////
    // 抽象方法    end
    ///////////////////////////////////////////////////////////////////////////

    //带有父控件查找
    public <T> T fv(int resId, View parent) {
        return (T) parent.findViewById(resId);
    }

    @Override
    public Activity getSelfActivity() {
        return getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束的时候，将presenter与view之间的联系断开，防止内存泄漏
         */
        if (mvpPre != null) {
            mvpPre.detachView();
        }
    }
}
