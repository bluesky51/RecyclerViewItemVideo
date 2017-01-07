package com.sky.sky.recyclerviewitemvideo.view;

import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;

import java.util.List;

/**
 * Created by BlueSky on 17/1/4.
 */

public interface VideoPlayerView {

    void showProgress();
    void hideProgress();
    void loadFailed(Throwable t);
    void loadVideo(List<VideoInfo.ResultBean.VideoListByTimeBean> videos);
}
