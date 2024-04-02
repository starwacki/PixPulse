package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;

/**
 * Created by Szymon Tarwacki 01.04.2024
 */
@Entity
class PhotoLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;


}
