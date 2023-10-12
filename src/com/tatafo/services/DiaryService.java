package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.dtos.LoginRequest;
import com.tatafo.dtos.RegisterUserRequest;

public interface DiaryService {
    void lock(String userName);

    void registerUser(RegisterUserRequest registerUserRequest);
    Diary findByUserName(String userName);
    void delete(String userName, String password);
    long count();
    void clear();
    Iterable <Diary> findAll();
    void unlock(LoginRequest loginRequest);
    void addEntry(String userName, String title, String body);
}
