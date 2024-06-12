package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/photo")
@AllArgsConstructor
class PhotoLikeController {

    private final PhotoLikeService photoLikeService;

    @PostMapping("/like")
    void like(@RequestParam String username, @RequestParam long photoId) {
        photoLikeService.like(username,photoId);
    }
}
