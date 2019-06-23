package com.example.hybss.mvpdemo.net;

import com.example.hybss.mvpdemo.constants.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit管理类
 */
public class RetrofitManager {
    public static final String BASEURL = "";
    private RetrofitManager() {
    }

    public static final  int TIMEOUT = 15; //超时时间
    private static volatile  RetrofitManager mInstance;
    private Retrofit mRetrofit;
    private OkHttpClient mOkhttpClient;

    /**
     * 单例化
     * @return
     */
    public static RetrofitManager newInstance(){
        if(mInstance == null){
            synchronized (RetrofitManager.class){
                if(mInstance == null){
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }





    /**
     * 初始化retrofit
     */
    private void  initRetrofit(){
       mRetrofit = new Retrofit.Builder()
               .baseUrl(BASEURL)
               .addConverterFactory(GsonConverterFactory.create())
               .addConverterFactory(ResponseConvert.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .client(mOkhttpClient)
               .build();
    }

    /**
     * 初始化okhttp
     * @return
     */
    private void initOkhttp(){
        // TODO: 2019/6/23  可以添加统一参数拦截器

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //关联相应的拦截器
        interceptor.setLevel(Constant.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        if(mOkhttpClient == null){
            synchronized ((RetrofitManager.class)){
                if(mOkhttpClient == null){
                    mOkhttpClient =  new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(TIMEOUT,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    public <T> T create(Class<T> clazz){

        initOkhttp();
        initRetrofit();

        if(mRetrofit != null){
            return mRetrofit.create(clazz);
        }
        return null;
    }

}
