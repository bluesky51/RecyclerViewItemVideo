package com.sky.sky.recyclerviewitemvideo.callback;

import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;

import java.util.List;

/**
 * Created by BlueSky on 17/1/4.
 */

public interface OnVideoInfoListListener {
    void onSuccessed(List<VideoInfo.ResultBean.VideoListByTimeBean> videos);
    void onFailed(Throwable e);
}
