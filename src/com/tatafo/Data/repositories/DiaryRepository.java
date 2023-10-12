package com.tatafo.Data.repositories;

import com.tatafo.Data.models.Diary;

public interface DiaryRepository {
    Diary save(Diary diary);
    void delete(Diary diary);
    Diary findById(int i);
    Iterable <Diary> findAll();
    long count();
    void clear();




}
