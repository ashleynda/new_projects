package com.tatafo.utils;

import com.tatafo.Data.models.Diary;
import com.tatafo.dtos.RegisterUserRequest;

public class Mapper {

    public static void map(RegisterUserRequest registerUserRequest, Diary diary) {
        diary.setUserName(registerUserRequest.getUserName());
        diary.setPassword(registerUserRequest.getPassword());
    }

//    public static Entry map(CreateEntryRequest createEntryRequest) {
//        Entry entry = new Entry();
//        entry.setOwnerName(createEntryRequest                                             );
//    }
}
