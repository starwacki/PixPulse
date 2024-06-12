package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/photo")
class PhotoCommentController {

    private final PhotoCommentQueryRepository photoCommentQueryRepository;
    private final PhotoCommentService photoCommentService;

    @GetMapping("/comment")
    PhotoCommentDTO getCommentById(@RequestParam Long id) {
        return photoCommentQueryRepository.selectCommentById(id);
    }

    @PostMapping("/comment")
    void addComment(@RequestParam Long photoId, @RequestParam String comment,@RequestParam String username) {
        photoCommentService.addComment(comment,username,photoId);
    }

    @GetMapping("/comments")
    List<PhotoCommentDTO> getPhotoComments(@RequestParam Long photoId) {
        return photoCommentQueryRepository.selectAllPhotoComments(photoId);
    }

    @DeleteMapping("/comment")
    void deleteComment(@RequestParam Long commentId) {
        photoCommentService.deleteComment(commentId);
    }




}
