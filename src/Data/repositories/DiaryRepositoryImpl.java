package Data.repositories;

import Data.models.Diary;
import Data.models.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiaryRepositoryImpl implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<>();
    private int count;

    public Diary save(Diary diary) {
        if (diary.getId() == 0) saveNew(diary);
        else update(diary);
        return diary;
    }

    @Override
    public void delete(Diary diary){
        Diary foundD = findById(diary.getId());
        diaries.remove(foundD);
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
