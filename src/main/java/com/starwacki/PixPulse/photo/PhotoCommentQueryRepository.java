package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Query repository can't be used to another operations than read,
 * It is special repository to separate read from other CRUD operations
 */
interface PhotoCommentQueryRepository extends Repository<PhotoComment,Long> {

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoCommentDTO(pc.user.username,pc.comment,pc.likes) " +
            "FROM PhotoComment pc " +
            "WHERE pc.id = :id")
    PhotoCommentDTO selectCommentById(long id);


    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoCommentDTO(pc.user.username,pc.comment,pc.likes) " +
            "FROM PhotoComment pc " +
            "WHERE pc.photo.id = :photoId")
    List<PhotoCommentDTO> selectAllPhotoComments(long photoId);

}
