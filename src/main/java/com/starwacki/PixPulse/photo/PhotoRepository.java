package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

/**
 * Created by Szymon Tarwacki 01.04.2024
 */
interface PhotoRepository extends JpaRepository<Photo, LinkOption> {
}
