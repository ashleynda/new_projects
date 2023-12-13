package tests;

import com.tatafo.dtos.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tatafo.services.DiaryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplTest {
    private DiaryServiceImpl diaryService;
    private RegisterUserRequest registerUserRequest;

    @BeforeEach
    public void startWithThis() {
        diaryService = new DiaryServiceImpl();
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("userName");
        registerUserRequest.setPassword("password");
    }

    @Test
    public void userCanRegister_CountIsOneTest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("ashley");
        registerUserRequest.setPassword("password");

        diaryService.registerUser(registerUserRequest);
        assertEquals(1, diaryService.count());
    }
}
//    @Test
//    public void canFindUserNameTest() {
//        diaryService.registerUser(registerUserRequest);
//        diaryService.findByUserName(registerUserRequest.getUserName());
//        assertEquals(1, diaryService.count());
//        assertEquals(registerUserRequest.getUserName(), diaryService.findByUserName(registerUserRequest.getUserName()).getUserName());
//    }
//    @Test
//    public void userRegisterWithUniqueUserName() {
//        diaryService.registerUser(registerUserRequest);
//        diaryService.findByUserName(registerUserRequest.getUserName());
//        assertEquals(1, diaryService.count());
//
//        assertThrows(IllegalArgumentException.class, ()-> diaryService.registerUser(registerUserRequest));
//    }
//    @Test
//    public void diariesCanBeCreatedAndDeleted() {
//        diaryService.registerUser(registerUserRequest);
//        diaryService.findByUserName(registerUserRequest.getUserName());
//        assertEquals(registerUserRequest.getUserName(), diaryService.findByUserName(registerUserRequest.getUserName()).getUserName());
//
//        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
//        diaryService.registerUser(registerUserRequest1);
//        diaryService.findByUserName(registerUserRequest1.getUserName());
//        assertEquals(2, diaryService.count());
//        assertEquals(registerUserRequest1.getUserName(), diaryService.findByUserName(registerUserRequest1.getUserName()).getUserName());
//
//        diaryService.delete(registerUserRequest.getUserName(),registerUserRequest.getPassword());
//        assertEquals(1,diaryService.count());
//       assertThrows(IllegalArgumentException.class, ()-> diaryService.findByUserName(registerUserRequest.getUserName()));
//
//    }
//
//
//}
