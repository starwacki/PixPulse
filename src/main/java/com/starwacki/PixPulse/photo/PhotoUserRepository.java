package com.starwacki.PixPulse.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PhotoUserRepository  extends JpaRepository<PhotoUser,Long> {

    PhotoUser findPhotoUserByUsername(String username);


}
