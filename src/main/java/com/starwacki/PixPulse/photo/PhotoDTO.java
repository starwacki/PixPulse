package com.starwacki.PixPulse.photo;

import java.time.LocalDateTime;

record PhotoDTO(
        String username,
        int likes,
        byte[] photo,
        LocalDateTime dateTime,
        PhotoCategory category
) {


}
