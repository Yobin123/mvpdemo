package com.example.hybss.mvpdemo.module;


import android.annotation.SuppressLint;

import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.listeners.ModuleCallback;
import com.example.hybss.mvpdemo.net.GankBaseResponse;
import com.example.hybss.mvpdemo.net.RetrofitManager;
import com.example.hybss.mvpdemo.net.ServerApi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeModuleImpl implements HomeFragmentContacts.IHomeModule {

    @Override
    public void getWelfareData(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
//        //获取福利列表
//        RetrofitManager.newInstance().create(ServerApi.class).getWaleFare(page, size).enqueue(new Callback<GankBaseResponse<List<WelfareBean>>>() {
//            @Override
//            public void onResponse(Call<GankBaseResponse<List<WelfareBean>>> call, Response<GankBaseResponse<List<WelfareBean>>> response) {
//                if (response != null) {
//                    if (response.isSuccessful() && !response.body().isError()) {
//                        if (null != response.body().getResults() && response.body().getResults().size() > 0) {
//                            callback.getModuleData(response.body().getResults());
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GankBaseResponse<List<WelfareBean>>> call, Throwable t) {
//
//            }
//        });

        getWaleFare(page, size, callback);

    }


    @SuppressLint("CheckResult")
    private void getWaleFare(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
        final Observable<GankBaseResponse<List<WelfareBean>>> observable = RetrofitManager.newInstance().create(ServerApi.class).getWaleFareNew(page, size);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GankBaseResponse<List<WelfareBean>>>() {
           
            @Override
            public void accept(GankBaseResponse<List<WelfareBean>> listGankBaseResponse) throws Exception {
                if (listGankBaseResponse.getResults() != null) {
                    callback.getModuleData(listGankBaseResponse.getResults());
                    
                }
            }
        });
    }


}