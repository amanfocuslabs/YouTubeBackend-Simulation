package com.mpp.youtubesimulationbackend.service.Impl;

import com.mpp.youtubesimulationbackend.dao.ChannelRepository;
import com.mpp.youtubesimulationbackend.dao.Impl.ChannelRepositoryImpl;
import com.mpp.youtubesimulationbackend.model.Channel;
import com.mpp.youtubesimulationbackend.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ChannelServiceImpl {
    @Autowired
    ChannelRepositoryImpl channelRepo;
    ChannelRepository channelRepository;
    ChannelServiceImpl()
    {
        channelRepo=new ChannelRepositoryImpl();
    }

    public  Channel createChannel(Channel channel)
    {
        return  channelRepo.createChannel(channel);
    }

    public  Channel editChannel(Channel channel)
    {
        channelRepo.changeDescription(channel,channel.getDescription());
        channelRepo.changeProfilePicture(channel,channel.getProfilePictureUrl());
        return channelRepo.getChannel(channel.getTitle());

    }

   public ResponseEntity<Object> removeChannel(Channel channel)
    {
        return channelRepo.deleteChannel(channel);
       // return true;

    }

    public List<Video> getVideos(String channelName)
    {
        //from video service
        return  null;
    }


}
