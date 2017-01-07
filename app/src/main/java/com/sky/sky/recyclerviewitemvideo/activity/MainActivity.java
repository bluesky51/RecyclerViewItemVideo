package com.sky.sky.recyclerviewitemvideo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sky.sky.recyclerviewitemvideo.R;
import com.sky.sky.recyclerviewitemvideo.adapter.VideoItemAdapter;
import com.sky.sky.recyclerviewitemvideo.bean.VideoInfo;
import com.sky.sky.recyclerviewitemvideo.event.BackEvent;
import com.sky.sky.recyclerviewitemvideo.presenter.VideoPresenterImpl;
import com.sky.sky.recyclerviewitemvideo.view.VideoPlayerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * MVC模式：
 * View：对应于布局文件
 * Model：业务逻辑和实体模型
 * Controllor：对应于Activity
 * <p>
 * <p>
 * MVP模式：
 * View 对应于Activity，负责View的绘制以及与用户交互
 * Model 依然是业务逻辑和实体模型
 * Presenter 负责完成View于Model间的交互
 * <p>
 * 备注：1》Model与View之间的交互由Presenter完成。
 * 2》Presenter与View之间的交互是通过接口的。
 */
public class MainActivity extends AppCompatActivity implements VideoPlayerView {
    VideoPresenterImpl videoPresenter;
    RelativeLayout loading;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        videoPresenter = new VideoPresenterImpl(MainActivity.this);
        videoPresenter.getVideoData();
    }

    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loading = (RelativeLayout) findViewById(R.id.loading);

    }

    @Override
    public void showProgress() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void loadFailed(Throwable t) {
        Toast.makeText(this, "请求失败，原因是:" + t, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadVideo(List<VideoInfo.ResultBean.VideoListByTimeBean> videos) {

        VideoItemAdapter adapter = new VideoItemAdapter(videos, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventBus.getDefault().post(new BackEvent());
    }

}
