package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.repositories.DiaryRepository;
import com.tatafo.Data.repositories.DiaryRepositoryImpl;
import com.tatafo.dtos.LoginRequest;
import com.tatafo.dtos.RegisterUserRequest;

import java.util.Objects;

public class DiaryServiceImpl implements DiaryService{
    DiaryRepository diaryRepository = new DiaryRepositoryImpl();

    @Override
    public void lock(String userName) {
        Diary foundDiary = findByUserName(userName);
        foundDiary.setIsLocked(String.valueOf(true));
        diaryRepository.save(foundDiary);


    }

    @Override
    public void registerUser(RegisterUserRequest registerUserRequest) {
        checkForUniqueUserName(registerUserRequest.getUserName());
        Diary newDiary = new Diary();
        newDiary.setUserName(registerUserRequest.getUserName());
        newDiary.setPassword(registerUserRequest.getPassword());
        diaryRepository.save(newDiary);
    }
    private void checkForUniqueUserName(String userName) {
        for (Diary existingName: diaryRepository.findAll()) {
            if (existingName.getUserName().equals(userName)){
                throw new IllegalArgumentException("USER NAME ALREADY IN USE");
            }
        }
    }
    @Override
    public Diary findByUserName(String userName) {
        for (Diary existingName : diaryRepository.findAll()){
            if (Objects.equals(existingName.getUserName(), userName))
                return existingName;
        }
       throw new IllegalArgumentException("not found");
    }
    @Override
    public void delete(String userName, String password) {
        Diary diary = validateUserName(userName);
        removeDiary(password, diary);
    }
    private void removeDiary(String password, Diary diary) {
        if (diary.getPassword().equals(password)){
            diaryRepository.delete(diary);
        }
        else {
            throw new IllegalArgumentException("Invalid Password");
        }
    }
    private Diary validateUserName(String userName) {
        for (Diary diary: diaryRepository.findAll()) {
            if (diary.getUserName().equals(userName)){
                return diary;
            }
        }
        throw new IllegalArgumentException("DIARY USER DOES NOT EXIST");
    }
    @Override
    public long count() {
        return diaryRepository.count();
    }
    @Override
    public void clear() {

    }

    @Override
    public Iterable<Diary> findAll() {
        return  diaryRepository.findAll();
    }

    @Override
    public void unlock(LoginRequest loginRequest) {
        Diary diary = findByUserName(loginRequest.getUserName());
        if (diary.getPassword().equals(loginRequest.getPassword())) diary.setIsLocked(String.valueOf(false));
        else throw new IllegalArgumentException("Incorrect Password");
        diaryRepository.save(diary);
    }

    @Override
    public void addEntry(String userName, String title, String body) {

    }


}
