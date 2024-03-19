package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * PhotoUser should be only use to create
 * relations in database between other entities.
 * PhotoUser is mapped to same table in database like user.
 * Created by Szymon Tarwacki 18.03.2024
 */

@Entity
@Table(name = "app_user")
class PhotoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Photo> photos = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Photo> comments = new HashSet<>();
}
