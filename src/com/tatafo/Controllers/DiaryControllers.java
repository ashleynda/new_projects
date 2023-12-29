package com.tatafo.Controllers;

import com.tatafo.Data.models.Diary;
import com.tatafo.dtos.request.*;
import com.tatafo.dtos.response.ApiResponse;
import com.tatafo.dtos.response.UpdateEntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tatafo.services.DiaryService;

@RestController
@RequestMapping("/Journal")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class DiaryControllers {
    @Autowired
    private DiaryService diaryService;
    @PostMapping("/register")
    public ApiResponse<Object> registerUser(@RequestBody RegisterUserRequest registerUserRequest)  {
        try {
            return new ApiResponse<>(diaryService.registerUser(registerUserRequest));
        } catch (Exception e) {
            return new ApiResponse<>(e.getMessage());
        }
    }


    @PatchMapping("/unlock")
    public ApiResponse<Object> unlockDiary(@RequestBody LoginRequest loginRequest){
        try {
            return new ApiResponse<>(diaryService.unlock(loginRequest));
        } catch (Exception e) {
            return new ApiResponse<>(e.getMessage());
        }

    }

    @PostMapping("/createNewEntry")
    public ApiResponse<Object> createEntry(@RequestBody CreateEntryRequest createEntryRequest){
        try {
            return new ApiResponse<>(diaryService.addEntry(createEntryRequest));
        } catch (Exception  e) {
            return new ApiResponse<>(e.getMessage());
        }
    }
    @GetMapping("/findDiary/{userName}")
    public Diary findDiary(@PathVariable String userName){
        return diaryService.findByUserName(userName);
    }

    @GetMapping("/findEntry/{userName}/{title}")
    public ApiResponse<Object> findEntry(@PathVariable String userName, @PathVariable String title){
        try {
            return new ApiResponse<>(diaryService.findEntry(userName, title));
        } catch (Exception e) {
            return new ApiResponse<>(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void delete(String password) {
        diaryService.delete(password);
    }

    @PatchMapping("/lock")
    public String lock(@RequestBody String username) {
        diaryService.lock(username);
        return "Locked";
    }

    @PatchMapping("/update-entry")
    public ApiResponse<Object> updateEntry(UpdateEntryRequest updateEntryRequest){
        try{
            return new ApiResponse<>(diaryService.updateEntry(updateEntryRequest));
        } catch (Exception error){
            return new ApiResponse<>(error.getMessage());
        }

    }

    @DeleteMapping("/delete-entry")
    public ApiResponse<Object> deleteEntry(DeleteEntryRequest deleteEntryRequest){

        try{
            return new ApiResponse<>(diaryService.deleteEntry(deleteEntryRequest));
        } catch (Exception error){
            return new ApiResponse<>(error.getMessage());
        }
    }

}
