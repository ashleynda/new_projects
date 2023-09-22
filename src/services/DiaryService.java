package services;

import Data.models.Diary;

public interface DiaryService {
    void registerUser(String userName, String password);
    Diary findByUserName(String userName);
    void delete(String userName, String passwoed);
    long count();
    void clear();
    Iterable <Diary> findAll();


}
