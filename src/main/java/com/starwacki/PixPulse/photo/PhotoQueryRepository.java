package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Query repository can't be used to another operations than read,
 * It is special repository to separate read from other CRUD operations
 * Created by Szymon Tarwacki 02.04.2024
 */
interface PhotoQueryRepository extends Repository<Photo, Long> {

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoDTO( p.user.username,p.likes,p.photo,p.addedDateTime,p.category ) " +
            "FROM Photo p " +
            "WHERE p.id = :id")
    PhotoDTO selectPhotoById(long id);

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoDTO( p.user.username,p.likes,p.photo,p.addedDateTime,p.category ) " +
            "FROM Photo p " +
            "WHERE p.user.username = :username " +
            "ORDER BY p.addedDateTime DESC")
    List<PhotoDTO> selectAllUserPhotos(String username);

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoDTO( p.user.username,p.likes,p.photo,p.addedDateTime,p.category ) " +
            "FROM Photo p " +
            "WHERE p.category = :category " +
            "ORDER BY p.addedDateTime DESC")
    List<PhotoDTO> selectAllPhotosByDate(PhotoCategory category);

    @Query("SELECT NEW com.starwacki.PixPulse.photo.PhotoDTO( p.user.username,p.likes,p.photo,p.addedDateTime,p.category ) " +
            "FROM Photo p " +
            "WHERE p.category = :category " +
            "ORDER BY p.likes DESC")
    List<PhotoDTO> selectAllPhotosByLikes(PhotoCategory category);







}
