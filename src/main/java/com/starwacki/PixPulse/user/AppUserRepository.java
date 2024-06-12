package com.starwacki.PixPulse.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AppUserRepository extends JpaRepository<AppUser,Long> {

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);


}
