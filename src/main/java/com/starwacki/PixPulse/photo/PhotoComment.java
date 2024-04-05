package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;

@Entity
class PhotoComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private int likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

}
