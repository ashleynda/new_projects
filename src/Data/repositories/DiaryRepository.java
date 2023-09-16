package Data.repositories;

import Data.models.Diary;

public interface DiaryRepository {
    Diary save(Diary diary);
    void delete(Diary diary);
    Diary findById(int i);
    Iterable <Diary> findAll();
    long count();
    void clear();



}
