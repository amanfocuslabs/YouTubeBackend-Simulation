package com.mpp.youtubesimulationbackend.dao;

import com.mpp.youtubesimulationbackend.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    //List<ChannelRepository> findAll();




}
