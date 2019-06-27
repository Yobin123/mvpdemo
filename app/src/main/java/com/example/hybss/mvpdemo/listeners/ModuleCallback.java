package com.example.hybss.mvpdemo.listeners;

import android.view.View;

/**
 * 回调给presenter方法。
 *
 * @param <T>
 */
public interface ModuleCallback<T> {

    void getModuleData(T data);

    void onFailure(Throwable throwable); // 回调相应的信息  
}
