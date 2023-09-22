package services;

import Data.models.Diary;
import Data.repositories.DiaryRepository;
import Data.repositories.DiaryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryServiceImpl implements DiaryService{
    DiaryRepository diaryRepository = new DiaryRepositoryImpl();


    @Override
    public void registerUser(String userName, String password) {
        checkForUniqueUserName(userName);
        Diary newDiary = new Diary();
        newDiary.setUserName(userName);
        newDiary.setPassword(password);
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


}
