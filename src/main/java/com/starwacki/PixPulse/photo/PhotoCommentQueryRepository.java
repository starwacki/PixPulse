package com.starwacki.PixPulse.photo;


import org.springframework.data.repository.Repository;

/**
 * Query repository can't be used to another operations than read,
 * It is special repository to separate read from other CRUD operations
 * Created by Szymon Tarwacki 02.04.2024
 */
interface PhotoCommentQueryRepository extends Repository<PhotoComment,Long> {
}
