package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class PhotoLikeService {

    private final PhotoLikeRepository photoLikeRepository;
    private final PhotoUserRepository photoUserRepository;
    private final PhotoRepository photoRepository;
    void like(String username, Long photoId) {
        PhotoLike photoLike = photoLikeRepository.getPhotoLike(photoUserRepository.findPhotoUserByUsername(username).getId(),photoId);
        if (photoLike==null)
            photoLikeRepository.save(PhotoLike.builder()
                    .photo(photoRepository.findById(photoId).get())
                    .user(photoUserRepository.findPhotoUserByUsername(username)).build());
        else
            photoLikeRepository.delete(photoLike);
    }
}
