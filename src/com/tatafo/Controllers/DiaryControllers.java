package com.tatafo.Controllers;

import com.tatafo.Data.models.Diary;
import com.tatafo.dtos.LoginRequest;
import com.tatafo.dtos.RegisterUserRequest;
import org.springframework.web.bind.annotation.*;
import com.tatafo.services.DiaryService;
import com.tatafo.services.DiaryServiceImpl;

@RestController
public class DiaryControllers {
    private DiaryService diaryService = new DiaryServiceImpl();
    @PostMapping("/register")
    public String registerUser(RegisterUserRequest registerUserRequest){
        diaryService.registerUser(registerUserRequest);
        return "Successful";
    }
    @PatchMapping("/unlock")
    public String unlockDiary(LoginRequest loginRequest){
        diaryService.unlock(loginRequest);
        return "Unlocked";
    }

    @PostMapping("/createNewEntry")
    public String createEntry(String userName, String title, String body){
       diaryService.addEntry(userName, title, body);
        return "Entry Created";
    }
    @GetMapping("/findDiary")
    public Diary findDiary(String userName){
        return diaryService.findByUserName(userName);
    }

    @DeleteMapping("/delete")
    public void delete(String userName, String password) {
        diaryService.delete(userName, password);
    }

    @PatchMapping("/lock")
    public String lock(String username) {
        diaryService.lock(username);
        return "Locked";
    }

//    @PatchMapping("/updateEntry")
//    public void updateEntry(String userName, String title, String body) {
//    }
}
