package com.starwacki.PixPulse.photo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Query repository can't be used to another operations than read,
 * It is special repository to separate read from other CRUD operations
 */
interface PhotoCommentQueryRepository extends Repository<PhotoComment,Long> {

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoCommentDTO( pc.user.username, pc.comment, pc.likes ) " +
            "FROM PhotoComment pc " +
            "WHERE pc.photo.id = :id")
    PhotoDTO selectPhotoById(long id);
}
