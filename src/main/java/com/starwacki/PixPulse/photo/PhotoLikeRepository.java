package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface PhotoLikeRepository extends JpaRepository<PhotoLike,Long> {

    @Query("SELECT pl " +
            "FROM PhotoLike pl " +
            "WHERE pl.user.id = :userId AND pl.photo.id = :photoId")
    PhotoLike getPhotoLike(Long userId, Long photoId);
}
