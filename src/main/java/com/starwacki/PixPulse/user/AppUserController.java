package com.starwacki.PixPulse.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/app-user/")
@AllArgsConstructor
class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    ResponseEntity<HttpStatus> register(@RequestParam String email, @RequestParam String password) {
        if (appUserService.isUserExist(email))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            appUserService.registerUser(email, password);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestParam String login, @RequestParam String password) {
        if (appUserService.isCorrectLoginAndPassword(login,password))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
