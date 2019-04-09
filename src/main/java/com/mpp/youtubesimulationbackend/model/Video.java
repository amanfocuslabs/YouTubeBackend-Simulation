package com.mpp.youtubesimulationbackend.model;

import com.mpp.youtubesimulationbackend.enumuerator.PrivacySettings;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="video")
public class Video {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private String tag;

    @Column(name = "published_date",nullable = false)
    private LocalDate publishedDate;

    @OneToMany(mappedBy="video")
    @Column(name = "thumbnailImage", nullable = false)
    private List<Image> thumbnailImageList;

    @Column(nullable = false)
    private String url;

    @Column(name = "privacy_settings",nullable = false)
    private PrivacySettings privacySettings;

    @ManyToOne
    private Channel channel;

    public Long getId() {
        return Id;
    }

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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Image> getThumbnailImageList() {
        return thumbnailImageList;
    }

    public void setThumbnailImageList(List<Image> thumbnailImageList) {
        this.thumbnailImageList = thumbnailImageList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PrivacySettings getPrivacySettings() {
        return privacySettings;
    }

    public void setPrivacySettings(PrivacySettings privacySettings) {
        this.privacySettings = privacySettings;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
