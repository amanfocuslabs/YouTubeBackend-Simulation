package com.mpp.youtubesimulationbackend.dao;

import com.mpp.youtubesimulationbackend.model.Video;

public interface VideoRepository {

    boolean insertVideoMetaData(Video video);

}
