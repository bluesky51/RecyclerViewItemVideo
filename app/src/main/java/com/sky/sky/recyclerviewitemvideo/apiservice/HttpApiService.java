package com.sky.sky.recyclerviewitemvideo.apiservice;

import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;
import com.sky.sky.recyclerviewitemvideo.constants.Constants;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by BlueSky on 17/1/4.
 */

public interface HttpApiService {

    @GET(Constants.PATH)
    Observable<VideoInfo> getVideoList(@Query("page") int page);
}
