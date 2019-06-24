package com.example.hybss.mvpdemo.module;

import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.listeners.ModuleCallback;
import com.example.hybss.mvpdemo.net.GankBaseResponse;
import com.example.hybss.mvpdemo.net.RetrofitManager;
import com.example.hybss.mvpdemo.net.ServerApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModuleImpl implements HomeFragmentContacts.IHomeModule {

    @Override
    public void getWelfareData(int page, int size, final ModuleCallback<List<WelfareBean>> callback) {
        //获取福利列表
        RetrofitManager.newInstance().create(ServerApi.class).getWaleFare(page, size).enqueue(new Callback<GankBaseResponse<List<WelfareBean>>>() {
            @Override
            public void onResponse(Call<GankBaseResponse<List<WelfareBean>>> call, Response<GankBaseResponse<List<WelfareBean>>> response) {
                if (response != null) {
                    if (response.isSuccessful() && !response.body().isError()) {
                        if (null != response.body().getResults() && response.body().getResults().size() > 0) {
                            callback.getModuleData(response.body().getResults());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GankBaseResponse<List<WelfareBean>>> call, Throwable t) {

            }
        });
    }


}
