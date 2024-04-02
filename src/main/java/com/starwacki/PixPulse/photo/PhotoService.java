package com.starwacki.PixPulse.photo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Szymon Tarwacki 01.04.2024
 */
@Service
class PhotoService {

    public PhotoDTO getPhotoById(int id) {
        return new PhotoDTO("test",1,new byte[]{101},  LocalDateTime.of(LocalDate.MAX,LocalTime.MAX),PhotoCategory.ARCHITECTURE);
    }

    public void addPhoto(byte[] photo, String username) {
        LocalDateTime actualDateTime = LocalDateTime.now();

    }

    public void deletePhotoById(int id) {
    }

    public Set<PhotoDTO> getAllUserPhotos(String username) {
        return new HashSet<>();
    }
}
