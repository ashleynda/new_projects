package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.dtos.Response.LoginUserResponse;
import com.tatafo.dtos.request.*;
import com.tatafo.dtos.Response.RegisterUserResponse;

public interface DiaryService {
    void lock(String userName);

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    Diary findByUserName(String userName);
    String delete(DeleteEntryRequest deleteEntryRequest);
    long count();
    void clear();
    Iterable <Diary> findAll();
    LoginUserResponse unlock(LoginRequest loginRequest);
    Entry addEntry(CreateEntryRequest createEntryRequest);
    void update(String userName, String oldPassword, String newPassword);

    Entry findEntry(String userName, String title);
    Entry updateEntry(UpdateEntryRequest updateEntryRequest);
}
