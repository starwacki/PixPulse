package com.starwacki.PixPulse.photo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class PhotoQueryRepositoryTest {

    @Autowired
    private PhotoQueryRepository photoQueryRepository;

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectPhotoById_whenPhotoExist() {

        int existPhotoId = 1;

        PhotoDTO photo = photoQueryRepository.selectPhotoById(existPhotoId);

        assertNotNull(photo);
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectPhotoById_whenPhotoNoExist() {

        int noExistPhotoId = 1111;

        PhotoDTO photo = photoQueryRepository.selectPhotoById(noExistPhotoId);

        assertNull(photo);
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByOldest_whenUserHasPhotos() {

        String existUsername = "testuser1";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByOldest(existUsername);

        int expectedPhotosNumber = 3;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByOldest_whenUserHasNotPhotos() {

        String existUsername = "testuser8";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByOldest(existUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByOldest_whenUserNoExist() {

        String noExistUsername = "noExistUser";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByOldest(noExistUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByOldest_whenUserHasPhotos_orderByOldest() {

        String existUsername = "testuser1";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByOldest(existUsername);

        int expectedPhotosNumber = 3;
        PhotoDTO photoDTO1 = userPhotos.get(0);
        PhotoDTO photoDTO2 = userPhotos.get(1);
        PhotoDTO photoDTO3 = userPhotos.get(2);
        assertEquals(expectedPhotosNumber,userPhotos.size());
        assertTrue(photoDTO1.dateTime().isBefore(photoDTO2.dateTime()));
        assertTrue(photoDTO2.dateTime().isBefore(photoDTO3.dateTime()));
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByNewest_whenUserHasPhotos() {

        String existUsername = "testuser1";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByNewest(existUsername);

        int expectedPhotosNumber = 3;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByNewest_whenUserHasNotPhotos() {

        String existUsername = "testuser8";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByNewest(existUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByNewest_whenUserNoExist() {

        String noExistUsername = "noExistUser";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByNewest(noExistUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByNewest_whenUserHasPhotos_orderByNewest() {

        String existUsername = "testuser1";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByNewest(existUsername);

        int expectedPhotosNumber = 3;
        PhotoDTO photoDTO1 = userPhotos.get(0);
        PhotoDTO photoDTO2 = userPhotos.get(1);
        PhotoDTO photoDTO3 = userPhotos.get(2);
        assertEquals(expectedPhotosNumber,userPhotos.size());
        assertTrue(photoDTO1.dateTime().isAfter(photoDTO2.dateTime()));
        assertTrue(photoDTO2.dateTime().isAfter(photoDTO3.dateTime()));
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByLikes_whenUserHasNotPhotos() {

        String existUsername = "testuser8";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByLikes(existUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByLikes_whenUserNoExist() {

        String noExistUsername = "noExistUser";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByLikes(noExistUsername);

        int expectedPhotosNumber = 0;
        assertEquals(expectedPhotosNumber,userPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllUserPhotosByLikes_whenUserHasPhotos_orderByLikes() {

        String existUsername = "testuser1";

        List<PhotoDTO> userPhotos = photoQueryRepository.selectAllUserPhotosByLikes(existUsername);

        int expectedPhotosNumber = 3;
        PhotoDTO photoDTO1 = userPhotos.get(0);
        PhotoDTO photoDTO2 = userPhotos.get(1);
        PhotoDTO photoDTO3 = userPhotos.get(2);
        assertEquals(expectedPhotosNumber,userPhotos.size());
        assertTrue(photoDTO1.likes() >= photoDTO2.likes());
        assertTrue(photoDTO2.likes() >= photoDTO3.likes());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByOldest_whenCategoryHasPhotos() {

        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByOldest(category);

        int expectedCategoryPhotosNumber = 3;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByOldest_whenCategoryHasNotPhotos() {

        PhotoCategory category = PhotoCategory.ARCHITECTURE;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByOldest(category);

        int expectedCategoryPhotosNumber = 0;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByOldest_whenCategoryHasPhotos_orderByOldest() {

        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByOldest(category);

        int expectedCategoryPhotosNumber = 3;
        PhotoDTO photoDTO1 = categoryPhotos.get(0);
        PhotoDTO photoDTO2 = categoryPhotos.get(1);
        PhotoDTO photoDTO3 = categoryPhotos.get(2);
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
        assertTrue(photoDTO1.dateTime().isBefore(photoDTO2.dateTime()));
        assertTrue(photoDTO2.dateTime().isBefore(photoDTO3.dateTime()));
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByNewest_whenCategoryHasPhotos() {

        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByNewest(category);

        int expectedCategoryPhotosNumber = 3;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByNewest_whenCategoryHasNotPhotos() {

        PhotoCategory category = PhotoCategory.ARCHITECTURE;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByNewest(category);

        int expectedCategoryPhotosNumber = 0;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByNewest_whenCategoryHasPhotos_orderByNewest() {

        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosByNewest(category);

        int expectedCategoryPhotosNumber = 3;
        PhotoDTO photoDTO1 = categoryPhotos.get(0);
        PhotoDTO photoDTO2 = categoryPhotos.get(1);
        PhotoDTO photoDTO3 = categoryPhotos.get(2);
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
        assertTrue(photoDTO1.dateTime().isAfter(photoDTO2.dateTime()));
        assertTrue(photoDTO2.dateTime().isAfter(photoDTO3.dateTime()));
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByLikes_whenCategoryHasPhotos() {

        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosOrderByLikes(category);

        int expectedCategoryPhotosNumber = 3;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByLikes_whenCategoryHasNotPhotos() {

        PhotoCategory category = PhotoCategory.ARCHITECTURE;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosOrderByLikes(category);

        int expectedCategoryPhotosNumber = 0;
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
    }

    @Test
    @Sql("classpath:photo_query_repository_test.sql")
    void selectAllCategoryPhotosByLikes_whenCategoryHasPhotos_orderByLikes() {
        PhotoCategory category = PhotoCategory.ANIMAL;

        List<PhotoDTO> categoryPhotos = photoQueryRepository.selectAllCategoryPhotosOrderByLikes(category);

        int expectedCategoryPhotosNumber = 3;
        PhotoDTO photoDTO1 = categoryPhotos.get(0);
        PhotoDTO photoDTO2 = categoryPhotos.get(1);
        PhotoDTO photoDTO3 = categoryPhotos.get(2);
        assertEquals(expectedCategoryPhotosNumber,categoryPhotos.size());
        assertTrue(photoDTO1.likes() >= photoDTO2.likes());
        assertTrue(photoDTO2.likes() >= photoDTO3.likes());
    }







}
