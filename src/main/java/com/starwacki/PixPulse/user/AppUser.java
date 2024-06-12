package com.starwacki.PixPulse.user;

import jakarta.persistence.*;
import lombok.Builder;

/**
 * Created by Szymon Tarwacki 18.03.2024
 */
@Entity
@Table(name = "app_user")
@Builder
class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
