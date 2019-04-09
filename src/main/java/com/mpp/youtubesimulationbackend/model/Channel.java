package com.mpp.youtubesimulationbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="channel")
public class Channel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "profilePictureUrl",nullable = false)
    private String profilePictureUrl;

    @OneToMany(mappedBy = "channel")
    @Column(name = "video",nullable = false)
    private List<Video> videoList;

    @ManyToOne
    private Account account;
}
