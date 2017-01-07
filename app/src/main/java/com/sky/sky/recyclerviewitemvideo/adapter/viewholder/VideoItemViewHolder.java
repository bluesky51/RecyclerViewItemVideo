package com.sky.sky.recyclerviewitemvideo.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sky.sky.recyclerviewitemvideo.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BlueSky on 17/1/5.
 */

public class VideoItemViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView img_user_head;
    public TextView tv_user_name;
    public TextView tv_create_time;

    public ImageView imageView;
    public TextView video_title;
    public ProgressBar item_progress;
    public ImageView img_video;
    public SurfaceView surfaceView;
    public  SeekBar seekBar;

    public TextView tv_duration;
    public TextView tv_time;

    public VideoItemViewHolder(View itemView) {
        super(itemView);
        img_user_head = (CircleImageView) itemView.findViewById(R.id.img_user_head);
        tv_user_name = (TextView) itemView.findViewById(R.id.tv_user_name);
        tv_create_time = (TextView) itemView.findViewById(R.id.tv_create_time);


        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        video_title = (TextView) itemView.findViewById(R.id.video_title);
        item_progress = (ProgressBar) itemView.findViewById(R.id.item_progress);
        img_video = (ImageView) itemView.findViewById(R.id.img_video);
        surfaceView = (SurfaceView) itemView.findViewById(R.id.surfaceView);
        seekBar = (SeekBar) itemView.findViewById(R.id.seekBar);

        tv_duration = (TextView) itemView.findViewById(R.id.tv_duration);
        tv_time = (TextView) itemView.findViewById(R.id.tv_time);
    }

}
