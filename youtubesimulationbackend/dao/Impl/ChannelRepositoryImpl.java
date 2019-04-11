package com.mpp.youtubesimulationbackend.dao.Impl;

import com.mpp.youtubesimulationbackend.dao.ChannelRepository;
import com.mpp.youtubesimulationbackend.model.Channel;
import com.mpp.youtubesimulationbackend.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


public class ChannelRepositoryImpl  {

     ChannelRepository channelRepository;

     @Autowired
     private EntityManager entityManager;

    public Channel createChannel (Channel channel)
    {

         return channelRepository.save(channel);
    }



    public  ResponseEntity<Object> deleteChannel(Channel channel)
    {
         Optional<Channel> deleteChannel = channelRepository.findById(channel.getId());
         if (deleteChannel.isPresent()) {
              Channel sample = deleteChannel.get();
              channelRepository.delete(sample);
         } else {
              throw new EntityNotFoundException();
         }
         return ResponseEntity.ok().build();
    }

    public  Channel getChannel(String channelName)
    {
         Channel channel = null;
         Query query;
         query = entityManager.createQuery("SELECT u FROM Channel u WHERE u.Title=:channelName");
         query.setParameter("channelName", channelName);
         try {
              channel = (Channel) query.getSingleResult();
         } catch (Exception e) {
              // Handle exception
         }
         return channel;
    }

    public Channel changeProfilePicture(Channel channel, String profilePicUrl)
    {
         Channel updatedChannel;
         Optional<Channel> searchChannel = channelRepository.findById(channel.getId());
         if (searchChannel.isPresent()) {
              Channel getChannel = searchChannel.get();
              getChannel.setProfilePictureUrl(profilePicUrl);
              updatedChannel = channelRepository.save(getChannel);
         } else {
              throw new EntityNotFoundException();
         }
         return updatedChannel;

    }

     public Channel changeDescription(Channel channel, String description)
     {

          Channel updatedChannel;
          Optional<Channel> searchChannel = channelRepository.findById(channel.getId());
          if (searchChannel.isPresent()) {
               Channel getChannel = searchChannel.get();
               getChannel.setDescription(description);
               updatedChannel = channelRepository.save(getChannel);
          } else {
               throw new EntityNotFoundException();
          }
          return updatedChannel;
     }

    public List<Video> getVideos(String channelName)
    {
        //from video service
         return  null;
    }
}
