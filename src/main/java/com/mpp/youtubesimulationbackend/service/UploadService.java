package com.mpp.youtubesimulationbackend.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String uploadImage(MultipartFile file);
    String uploadVideo(MultipartFile file);
}
