package com.tatafo.Data.repositories;

import com.tatafo.Data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<>();


    public Diary save(Diary diary) {
        if (diary.getId() == 0) saveNew(diary);
        else update(diary);
        return diary;
    }

    @Override
    public void delete(Diary diary){
        diaries.remove(diary);
    }

    private void saveNew(Diary diary) {
        diary.setId(generateId());
        diaries.add(diary);
    }

    private void update(Diary diary) {
        Diary newDiary = findById(diary.getId());
        newDiary.setUserName(diary.getUserName());
    }

    private int generateId() {
        return diaries.size() + 1;
    }

    public long count() {
        return diaries.size();
    }

    @Override
    public void clear() {
        diaries.clear();
    }



    public Diary findById(int id) {
        for (Diary diary : diaries){
            if (diary.getId() == id) return diary;
        }
       return null;
    }

    @Override
    public Iterable<Diary> findAll() {
        return diaries;
    }
}
