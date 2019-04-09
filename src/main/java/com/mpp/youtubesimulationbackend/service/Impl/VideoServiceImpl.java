package com.mpp.youtubesimulationbackend.service.Impl;

import com.mpp.youtubesimulationbackend.model.Video;
import com.mpp.youtubesimulationbackend.service.UploadService;
import com.mpp.youtubesimulationbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private UploadService uploadService;

    public Video uploadVideo(Video video){
//        uploadService.uploadVideo(video);

        Video newVideo = new Video();
        return newVideo;
    }
}
