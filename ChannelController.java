package com.mpp.youtubesimulationbackend.controller;

import com.mpp.youtubesimulationbackend.model.Channel;
import com.mpp.youtubesimulationbackend.model.Video;
import com.mpp.youtubesimulationbackend.service.Impl.ChannelServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelController {

    ChannelServiceImpl serviceChannel;

    public  Channel createChannel(Channel channel)
    {
        return serviceChannel.createChannel(channel);
    }
    public  Channel editChannel(Channel channel)
    {
        return  serviceChannel.editChannel(channel);
    }

    //@RequestMapping("/channel")

    @RequestMapping(value = "/channel",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> removeChannel(Channel channel)
    {
        return  serviceChannel.removeChannel(channel);
    }

    public List<Video> getVideos(String channelName)
    {
        //from video service
        return  null;
    }

}
