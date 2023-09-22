package tests;

import Data.repositories.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplTest {
    private DiaryServiceImpl diaryService;
    @BeforeEach
    public void startWithThis() {
        diaryService = new DiaryServiceImpl();
    }
    @Test
    public void userCanRegister_CountIsOneTest() {
        diaryService.registerUser("Ashley", "password");
        assertEquals(1, diaryService.count());
    }

    @Test
    public void canFindUserNameTest() {
        diaryService.registerUser("Ashley", "password");
        diaryService.findByUserName("Ashley");
        assertEquals(1, diaryService.count());
        assertEquals("Ashley", diaryService.findByUserName("Ashley").getUserName());
    }
    @Test
    public void userRegisterWithUniqueUserName() {
        diaryService.registerUser("Ashley", "password");
        diaryService.findByUserName("Ashley");
        assertEquals(1, diaryService.count());

        assertThrows(IllegalArgumentException.class, ()-> diaryService.registerUser("Ashley", "password"));
    }
    @Test
    public void diariesCanBeCreatedAndDeleted() {
        diaryService.registerUser("Ashley", "password");
        diaryService.findByUserName("Ashley");
        assertEquals("Ashley", diaryService.findByUserName("Ashley").getUserName());

        diaryService.registerUser("Tobi", "password");
        diaryService.findByUserName("Tobi");
        assertEquals(2, diaryService.count());
        assertEquals("Tobi", diaryService.findByUserName("Tobi").getUserName());

        diaryService.delete("Tobi","password");
        assertEquals(1,diaryService.count());
       assertThrows(IllegalArgumentException.class, ()-> diaryService.findByUserName("Tobi"));

    }


}
