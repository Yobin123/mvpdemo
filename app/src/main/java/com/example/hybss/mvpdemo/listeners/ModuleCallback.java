package com.example.hybss.mvpdemo.listeners;

/**
 * 回调给presenter方法。
 *
 * @param <T>
 */
public interface ModuleCallback<T> {
    void getModuleData(T data);
}
