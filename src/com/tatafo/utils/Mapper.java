package com.tatafo.utils;

import com.tatafo.Data.models.Diary;
import com.tatafo.dtos.request.RegisterUserRequest;
import com.tatafo.dtos.Response.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
//    public static Entry map(CreateEntryRequest createEntryRequest) {
//    }
//        Entry entry = new Entry();
//        entry.setOwnerName(createEntryRequest                                             );
//    }

    public static Diary map(RegisterUserRequest registerUserRequest) {
        Diary diary = new Diary();
        diary.setUserName(registerUserRequest.getUserName());
        diary.setPassword(registerUserRequest.getPassword());
        return diary;
    }

    public static RegisterUserResponse map (Diary diary){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUserName(diary.getUserName());
        registerUserResponse.setRegisterDate(DateTimeFormatter.ofPattern("EEE dd/MMM/YYYY HH:mm:ss a").format(LocalDateTime.now()));
        return registerUserResponse;
    }


}
