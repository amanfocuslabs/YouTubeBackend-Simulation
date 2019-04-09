package com.mpp.youtubesimulationbackend.controller;

import com.mpp.youtubesimulationbackend.model.Video;
import com.mpp.youtubesimulationbackend.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/rest/video")
public class VideoContoller {
    private static final Logger logger = LoggerFactory.getLogger(VideoContoller.class);

    @Autowired
    public UploadService uploadService;

    @RequestMapping(value = "/uploadVideo",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Video uploadVideo(@RequestParam("file") MultipartFile file){
        String fileName = uploadService.uploadVideo(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        Video videoResponse = new Video();
        videoResponse.setTitle(fileName);
        videoResponse.setDescription(fileName);
        videoResponse.setUrl(fileDownloadUri);
        videoResponse.setSize(file.getSize());

        return videoResponse;
    }
}
