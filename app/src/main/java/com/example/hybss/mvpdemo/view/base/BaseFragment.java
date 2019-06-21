package com.example.hybss.mvpdemo.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

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


    protected abstract P bindPresenter();

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
