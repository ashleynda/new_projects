package tests;

import Data.models.Diary;
import Data.repositories.DiaryRepository;
import Data.repositories.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DiaryRepositoryImplTest {
    private DiaryRepositoryImpl diaryRepository;

    @BeforeEach
    public void startWithThis() {
        diaryRepository = new DiaryRepositoryImpl();
        }


    @Test
    public void saveOneDiary_CountIsOneTest() {
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
    }
    @Test
    public void saveOneDiary_FindByIdTest() {
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
        assertEquals(diary, diaryRepository.findById(1));
    }
    @Test
    public void updateDiaryTest() {
        Diary diary = new Diary();
        diary.setUserName("esther");
        diaryRepository.save(diary);

        Diary updateDiary = new Diary();
        updateDiary.setId(1);
        updateDiary.setUserName("americana");
        diaryRepository.save(updateDiary);
        assertEquals("americana", diaryRepository.findById(1).getUserName());
        assertEquals(1, diaryRepository.count());
    }
    @Test
    public void deleteOneDiary_ReduceCountBy1Test() {
        Diary diary = new Diary();
        diary.setUserName("Tomide");
        diaryRepository.save(diary);

        Diary updateDiary = new Diary();
        diaryRepository.save(updateDiary);
        diaryRepository.delete(updateDiary);
        assertEquals(1, diaryRepository.count());
    }
    @Test
    public void findDiaryDeletedTest() {
        Diary diary = new Diary();
        diary.setUserName("Tomide");
        diaryRepository.save(diary);

        Diary updateDiary = new Diary();
        diaryRepository.save(updateDiary);
        diaryRepository.delete(updateDiary);
        assertNull(diaryRepository.findById(2));
    }
    @Test
    public void findAllDiaryTest() {
        Diary diary = new Diary();
        diary.setUserName("Tomide");
        diary.setUserName("Kevin");
        diaryRepository.save(diary);

        Diary updateDiary = new Diary();
        diaryRepository.save(updateDiary);
        diaryRepository.findAll();


    }


}
