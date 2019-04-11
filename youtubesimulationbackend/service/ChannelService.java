package com.mpp.youtubesimulationbackend.service;

import com.mpp.youtubesimulationbackend.model.Channel;
import com.mpp.youtubesimulationbackend.model.Video;

import java.util.List;

public interface ChannelService {
    void createChannel(Channel channel);
    void editChannel(Channel channel);
    void getChannel(String channelName);
    List<Video> getVideos(String channelName);
    void deleteChannel(Channel channel);



}
