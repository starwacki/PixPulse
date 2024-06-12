package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class PhotoCommentService {

    private final PhotoRepository photoRepository;
    private final PhotoCommentRepository photoCommentRepository;
    private final PhotoUserRepository photoUserRepository;


    void addComment(String comment, String username, Long photoId) {
        photoCommentRepository.save(PhotoComment.builder()
                .comment(comment)
                .photo(photoRepository.findById(photoId).get())
                .user(photoUserRepository.findPhotoUserByUsername(username))
                .build());
    }

    public void deleteComment(Long commentId) {
        photoCommentRepository.deleteById(commentId);
    }
}

