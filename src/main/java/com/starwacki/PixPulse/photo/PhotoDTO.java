package com.starwacki.PixPulse.photo;

import java.time.LocalDateTime;

/**
 * Created by Szymon Tarwacki 01.04.2024
 */
record PhotoDTO(
        String username,
        int likes,
        byte[] photo,
        LocalDateTime dateTime,
        PhotoCategory category
) {


}
