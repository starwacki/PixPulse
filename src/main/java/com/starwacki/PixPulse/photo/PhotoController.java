package com.starwacki.PixPulse.photo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("api/v1/photo")
@AllArgsConstructor
class PhotoController {

    private PhotoService photoService;

    @GetMapping("/{id}")
    private PhotoDTO getPhotoById(@PathVariable int id) {
        return photoService.getPhotoById(id);
    }

    @GetMapping("/")
    private Set<PhotoDTO> getAllUserPhotos(@RequestParam String username) {
        return photoService.getAllUserPhotos(username);
    }

    @DeleteMapping("/{id}")
    private void deletePhotoById(@PathVariable int id) {
        photoService.deletePhotoById(id);
    }

    @PostMapping("/")
    private void postPhoto(@RequestParam byte[] photo,@RequestParam String username) {
        photoService.addPhoto(photo,username);
    }





}
