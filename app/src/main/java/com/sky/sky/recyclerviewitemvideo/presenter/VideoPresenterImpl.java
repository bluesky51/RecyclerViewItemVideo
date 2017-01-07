package com.sky.sky.recyclerviewitemvideo.presenter;

import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;
import com.sky.sky.recyclerviewitemvideo.callback.OnVideoInfoListListener;
import com.sky.sky.recyclerviewitemvideo.model.VideoModel;
import com.sky.sky.recyclerviewitemvideo.model.VideoModelImpl;
import com.sky.sky.recyclerviewitemvideo.view.VideoPlayerView;

import java.util.List;

/**
 * Created by BlueSky on 17/1/4.
 */

public class VideoPresenterImpl implements VideoPresenter, OnVideoInfoListListener {

    /**
     * WeatherModel和WeatherView都是通过接口来实现，这就Java设计原则中依赖倒置原则使用
     */
    private VideoModel videoModel;
    private VideoPlayerView videoPlayerView;

    public VideoPresenterImpl(VideoPlayerView videoPlayerView) {
        this.videoPlayerView = videoPlayerView;
        videoModel = new VideoModelImpl(this);
    }

    @Override
    public void getVideoData() {
        videoPlayerView.showProgress();
        videoModel.getVideoData();

    }

    @Override
    public void onSuccessed(List<VideoInfo.ResultBean.VideoListByTimeBean> videos) {
        videoPlayerView.hideProgress();
        videoPlayerView.loadVideo(videos);
    }


    @Override
    public void onFailed(Throwable e) {
        videoPlayerView.hideProgress();
        videoPlayerView.loadFailed(e);
    }
}
