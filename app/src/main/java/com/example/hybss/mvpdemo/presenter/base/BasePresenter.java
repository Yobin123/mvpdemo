package com.example.hybss.mvpdemo.presenter.base;

import com.example.hybss.mvpdemo.presenter.interfaces.IPresenter;
import com.example.hybss.mvpdemo.view.intefaces.IView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    //这里使用弱引用，有的时候activity关闭不一定走onDestroy,使用弱引用可以及时回收IVew
    protected Reference<V> mvpRef;


    public BasePresenter(V view) {
        attachView(view);  //进行绑定
    }

    private void attachView(V view) {
        mvpRef = new WeakReference<V>(view);
    }

    /**
     * 获取相应的view
     *
     * @return V
     */
    protected V getView() {
        if (null != mvpRef) {
            return mvpRef.get();
        }
        return null;
    }

    /**
     * 主要用于判断Iveiw的生命周期是否结束，防止出现内存泄漏
     *
     * @return
     */
    protected boolean isViewAttach() {
        return null != mvpRef && null != mvpRef.get();
    }

    @Override
    public void detachView() {
        if (null != mvpRef) {
            mvpRef.clear();
            mvpRef = null;
        }
    }
}
