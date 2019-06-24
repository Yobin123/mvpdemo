package com.example.hybss.mvpdemo.net;

import com.example.hybss.mvpdemo.beans.WelfareBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 网络相关接口处理
 */
public interface ServerApi {
    @GET("data/福利/{size}/{page}")
    Call<GankBaseResponse<List<WelfareBean>>> getWaleFare(@Path("size") int size, @Path("page") int page);

}
