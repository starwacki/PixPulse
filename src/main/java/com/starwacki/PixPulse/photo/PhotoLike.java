package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;

@Entity
class PhotoLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;


}
