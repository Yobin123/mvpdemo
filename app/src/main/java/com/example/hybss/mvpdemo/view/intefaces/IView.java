package com.example.hybss.mvpdemo.view.intefaces;


import android.app.Activity;

/**
 * 所有的view(Activity，Fragment,fragmentActivity)都必须实现该接口。
 */
public interface IView {
    /**
     * 这个方法是为了当presenter中需要获取上下文对象时，传递上下文对象，而不是让presenter直接持有上下文对象
     *
     * @return
     */
    Activity getSelfActivity();
}


