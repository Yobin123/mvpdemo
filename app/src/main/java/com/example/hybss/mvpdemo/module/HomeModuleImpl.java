package com.example.hybss.mvpdemo.module;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.listeners.ModuleCallback;
import com.example.hybss.mvpdemo.net.GankBaseResponse;
import com.example.hybss.mvpdemo.net.RetrofitManager;
import com.example.hybss.mvpdemo.net.ServerApi;
import com.example.hybss.mvpdemo.oknet.OkManager;
import com.example.hybss.mvpdemo.utils.LogUtil;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModuleImpl implements HomeFragmentContacts.IHomeModule {

    //    @Override
//    public void getWelfareData(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
//        //获取福利列表
//        RetrofitManager.newInstance(). create(ServerApi.class).getWaleFare(page, size).enqueue(new Callback<GankBaseResponse<List<WelfareBean>>>() {
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
//                callback.onFailure(t);
//            }
//        });
//
////        getWaleFare(page, size, callback);
//
//    } 
    @Override
    public void getWelfareData(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
        final String url = String.format("http://gank.io/api/data/福利/%d/%d", 10, 1);
        OkManager.getInstance().getAsynBackStringWithoutParams(url, new OkManager.ResponseCallBack() {
            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(String data) {//需要解析，
                LogUtil.d("----->>", "---->>data = " + data);
                
            }

            @Override
            public void onError(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }
        });
    }


//    @SuppressLint("CheckResult")
//    private void getWaleFare(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
//        final Observable<GankBaseResponse<List<WelfareBean>>> observable = RetrofitManager.newInstance().create(ServerApi.class).getWaleFareNew(page, size);
//        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GankBaseResponse<List<WelfareBean>>>() {
//           
//            @Override
//            public void accept(GankBaseResponse<List<WelfareBean>> listGankBaseResponse) throws Exception {
//                if (listGankBaseResponse.getResults() != null) {
//                    callback.getModuleData(listGankBaseResponse.getResults());
//                    
//                }
//            }
//        });
//    }


}
