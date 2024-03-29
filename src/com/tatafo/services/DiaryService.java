package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.dtos.request.*;
import com.tatafo.dtos.response.LoginUserResponse;
import com.tatafo.dtos.response.UpdateEntryResponse;
import com.tatafo.dtos.response.RegisterUserResponse;

import java.util.List;

public interface DiaryService {
    void lock(String userName);

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    Diary findByUserName(String userName);
    void delete(String password);
    long count();
    void clear();
    Iterable <Diary> findAll();
    LoginUserResponse unlock(LoginRequest loginRequest);
    Entry addEntry(CreateEntryRequest createEntryRequest);
    void update(String userName, String oldPassword, String newPassword);
//    List<Entry> findEntries(String title, String userName);

    Entry findEntry(String userName, String title);

    UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest);

    String deleteEntry(DeleteEntryRequest deleteEntryRequest);
}
