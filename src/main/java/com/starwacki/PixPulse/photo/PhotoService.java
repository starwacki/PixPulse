package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
class PhotoService {

    private final PhotoRepository photoRepository;

    private final PhotoUserRepository photoUserRepository;

    void addPhoto(byte[] photo, String username,PhotoCategory photoCategory) {
        PhotoUser photoUser = photoUserRepository.findPhotoUserByUsername(username);
        photoRepository.save(Photo.builder()
                .user(photoUserRepository.findPhotoUserByUsername(username))
                .photo(photo)
                .addedDateTime(LocalDateTime.now())
                .category(photoCategory)
                .build());
    }

    void deletePhotoById(Long id) {
        photoRepository.deleteById(id);
    }

}
