package com.starwacki.PixPulse.photo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter(AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@ToString
class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] photo;

    private LocalDateTime addedDateTime;

    private int likes;

    @Enumerated(EnumType.STRING)
    private PhotoCategory category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PhotoUser user;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL)
    private Set<Photo> comments = new HashSet<>();


}
