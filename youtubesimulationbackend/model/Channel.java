package com.mpp.youtubesimulationbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="channel")
public class Channel {

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return Id;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
