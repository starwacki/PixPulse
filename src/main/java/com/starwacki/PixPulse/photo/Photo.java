package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Szymon Tarwacki 18.03.2024
 */
@Entity
@Getter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] photo;

    private LocalDateTime addedDateTime;

    private int likes;

    private PhotoCategory category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL)
    private Set<Photo> comments = new HashSet<>();

}
