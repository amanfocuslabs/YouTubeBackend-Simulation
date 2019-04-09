package com.mpp.youtubesimulationbackend.model;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Video video;
}
