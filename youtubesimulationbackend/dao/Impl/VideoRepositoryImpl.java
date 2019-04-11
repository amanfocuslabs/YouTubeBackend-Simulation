package com.mpp.youtubesimulationbackend.dao.Impl;

import com.mpp.youtubesimulationbackend.dao.VideoRepository;
import com.mpp.youtubesimulationbackend.model.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class VideoRepositoryImpl implements VideoRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private Session getSession(){
        Session session = null;

        try {
            session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        }catch (Exception e){
            e.printStackTrace();
        }

        return session;
    }

    public boolean insertVideoMetaData(Video video){
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(video);
            System.out.println("Video meta data is inserted sucessfully with an Id::" + id);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
