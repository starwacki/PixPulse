package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Szymon Tarwacki 18.03.2024
 */
@Entity
class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] photo;

    private LocalDateTime addedDateTime;

    private int likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL)
    private Set<Photo> comments = new HashSet<>();

}
