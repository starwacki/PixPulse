package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/photo")
@AllArgsConstructor
class PhotoController {

    private PhotoService photoService;
    private PhotoQueryRepository photoQueryRepository;

    @GetMapping("/")
    private PhotoDTO getPhotoById(@RequestParam  int id) {
        return photoQueryRepository.selectPhotoById(id);
    }

    @GetMapping("/username")
    private List<PhotoDTO> getAllUserPhotos(@RequestParam String username) {
        return photoQueryRepository.selectAllUserPhotosByNewest(username);
    }

    @DeleteMapping("/")
    private void deletePhotoById(@RequestParam Long id) {
        photoService.deletePhotoById(id);
    }

    @PostMapping("/")
    private void postPhoto(@RequestParam byte[] photo,@RequestParam String username,@RequestParam PhotoCategory photoCategory) {
        photoService.addPhoto(photo,username,photoCategory);
    }


    @GetMapping("/category/")
    private List<PhotoDTO> getMostPopularPhotosInCategory(@RequestParam PhotoCategory photoCategory) {
        return photoQueryRepository.selectAllCategoryPhotosOrderByLikes(photoCategory);
    }








}
