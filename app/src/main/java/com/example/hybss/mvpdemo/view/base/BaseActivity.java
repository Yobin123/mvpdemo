package com.example.hybss.mvpdemo.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

public abstract class BaseActivity<P extends IPresenter> extends FragmentActivity implements IView, View.OnClickListener {

    //presenter对象
    protected P mvpPre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPre = bindPresenter();
    }

    @Override
    public Activity getSelfActivity() {
        return this; //获取该对象。
    }

    //绑定presenter
    protected abstract P bindPresenter();
    

    //进行控件寻找
    public <T> T fv(int resId) {
        return (T) findViewById(resId);
    }

    //带有父控件查找
    public <T> T fv(int resId, View parent) {
        return (T) parent.findViewById(resId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束的时候，将presenter与view之间的联系断开，防止内存泄漏
         */
        if (mvpPre != null) {
            mvpPre.detachView();
        }
    }
}
