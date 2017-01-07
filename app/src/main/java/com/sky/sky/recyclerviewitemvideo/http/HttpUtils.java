package com.sky.sky.recyclerviewitemvideo.http;

import com.sky.sky.recyclerviewitemvideo.apiservice.HttpApiService;
import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;
import com.sky.sky.recyclerviewitemvideo.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlueSky on 17/1/4.
 */

public class HttpUtils {
    private static  HttpUtils httpUtils=null;
    private Retrofit retrofit;
    public static HttpUtils getHttpUtils(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public HttpUtils() {
        retrofit =new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public void getVideoList(Subscriber<VideoInfo> subscriber,int page){
        HttpApiService httpApiService = retrofit.create(HttpApiService.class);
        Observable<VideoInfo> videoInfoObservable = httpApiService.getVideoList(page);
        videoInfoObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }
}
