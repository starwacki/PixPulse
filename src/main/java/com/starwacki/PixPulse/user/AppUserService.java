package com.starwacki.PixPulse.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AppUserService {

    private final AppUserRepository appUserRepository;

    boolean isUserExist(String username) {
        return  appUserRepository.existsByUsername(username);
    }

    void registerUser(String username, String password) {
        appUserRepository.save(AppUser.builder()
                .username(username)
                .password(password).build());
    }

    boolean isCorrectLoginAndPassword(String username,String password) {
        return appUserRepository.existsByUsernameAndPassword(username,password);
    }


}
