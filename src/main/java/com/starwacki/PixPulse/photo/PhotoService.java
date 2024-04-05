package com.starwacki.PixPulse.photo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Service
class PhotoService {

    PhotoDTO getPhotoById(int id) {
        return new PhotoDTO("test",1,new byte[]{101},  LocalDateTime.of(LocalDate.MAX,LocalTime.MAX),PhotoCategory.ARCHITECTURE);
    }

    void addPhoto(byte[] photo, String username) {
        LocalDateTime actualDateTime = LocalDateTime.now();
    }

    void deletePhotoById(int id) {
    }

    Set<PhotoDTO> getAllUserPhotos(String username) {
        return new HashSet<>();
    }
}
