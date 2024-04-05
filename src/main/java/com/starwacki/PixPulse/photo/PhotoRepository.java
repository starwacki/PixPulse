package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;


interface PhotoRepository extends JpaRepository<Photo, LinkOption> {
}
