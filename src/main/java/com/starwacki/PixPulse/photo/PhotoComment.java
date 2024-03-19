package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;

/**
 * Created by Szymon Tarwacki 18.03.2024
 */
@Entity
class PhotoComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

}
