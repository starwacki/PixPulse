package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PhotoRepository extends JpaRepository<Photo,Long> {
}
