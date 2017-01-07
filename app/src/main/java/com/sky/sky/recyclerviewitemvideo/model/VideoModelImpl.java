package com.sky.sky.recyclerviewitemvideo.model;

import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;
import com.sky.sky.recyclerviewitemvideo.callback.OnVideoInfoListListener;
import com.sky.sky.recyclerviewitemvideo.http.HttpUtils;

import rx.Subscriber;

/**
 * Created by BlueSky on 17/1/4.
 */

public class VideoModelImpl implements VideoModel {
    private OnVideoInfoListListener onVideoInfoListListener;

    public VideoModelImpl(OnVideoInfoListListener onVideoInfoListListener) {
        this.onVideoInfoListListener = onVideoInfoListListener;
    }

    @Override
    public void getVideoData() {
        HttpUtils.getHttpUtils().getVideoList(new Subscriber<VideoInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (onVideoInfoListListener!=null) {
                    onVideoInfoListListener.onFailed(e);
                }

            }

            @Override
            public void onNext(VideoInfo videoInfo) {
                if (onVideoInfoListListener!=null) {
                    onVideoInfoListListener.onSuccessed(videoInfo.getResult().getVideo_list_by_time());
                }

            }
        },1);
    }
}
