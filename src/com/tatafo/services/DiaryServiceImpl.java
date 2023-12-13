package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.DiaryRepository;
import com.tatafo.dtos.Response.LoginUserResponse;
import com.tatafo.dtos.request.CreateEntryRequest;
import com.tatafo.dtos.request.LoginRequest;
import com.tatafo.dtos.request.RegisterUserRequest;
import com.tatafo.dtos.Response.RegisterUserResponse;
import com.tatafo.exceptions.DiaryExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tatafo.utils.Mapper.map;

@Service
public class DiaryServiceImpl implements DiaryService{
    @Autowired
    DiaryRepository diaryRepository;
    @Autowired
    private EntryService entryService;

    @Override
    public void lock(String userName) {
        Diary foundDiary = findByUserName(userName);
        foundDiary.setLocked(true);
        diaryRepository.save(foundDiary);
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        checkForUniqueUserName(registerUserRequest.getUserName());
//        Diary newDiary = new Diary();
//        newDiary.setUserName(registerUserRequest.getUserName());
//        newDiary.setPassword(registerUserRequest.getPassword());
        return map(diaryRepository.save(map(registerUserRequest)));
        
    }

    @Override
    public Diary findByUserName(String userName) {
        Optional<Diary> diary = findBy(userName);
        if (diary.isPresent()){
            return diary.get();
        }
        throw new IllegalArgumentException("Diary not found");
    }


    private void checkForUniqueUserName(String userName) {
        Optional<Diary> diary = findBy(userName);
        if (diary.isPresent())
            throw new DiaryExistException("Diary Created Successfully");
//        for (Diary existingName: diaryRepository.findAll()) {
//            if (existingName.getUserName().equals(userName)){
//                throw new IllegalArgumentException("USER NAME ALREADY IN USE");
//            }
//        }
    }
//    @Override
//    public Diary findByUserName(String userName) {
//        for (Diary diary : diaryRepository.findBy(userName))
//            if (diary.getUserName().equals(userName))
//                return diary;
//       throw new IllegalArgumentException("not found");
//    }
    @Override
    public void delete(String password) {
        Diary diary = validateUserName(password);
        delete(password);
    }
//    private void removeDiary(String password, Diary diary) {
//        if (diary.getPassword().equals(password)){
//            diaryRepository.delete(diary);
//        }
//        else {
//            throw new IllegalArgumentException("Invalid Password");
//        }
//    }
    private Diary validateUserName(String userName) {
        Optional<Diary> diary = findBy(userName);
        if (diary.isPresent())
            return diary.get();
        throw new IllegalArgumentException("DIARY USER DOES NOT EXIST");
    }
    @Override
    public long count() {
        return diaryRepository.count();
    }
    @Override
    public void clear() {

    }

    public Optional<Diary> findBy(String userName){
        Optional<Diary> diary = diaryRepository.findDiaryByUserName(userName);
        return diary;
    }

    @Override
    public Iterable<Diary> findAll() {
        return  diaryRepository.findAll();
    }

    @Override
    public LoginUserResponse unlock(LoginRequest loginRequest) {
            Optional<Diary> diaryOptional = diaryRepository.findDiaryByUserName(loginRequest.getUserName());

            if (diaryOptional.isEmpty()) {
                throw new IllegalArgumentException("Diary not found");
            }

            Diary diary = diaryOptional.get();

            if (diary.getPassword() == null || !diary.getPassword().equals(loginRequest.getPassword())) {
                throw new IllegalArgumentException("User credentials not correct");
                // Alternatively, you can return a LoginUserResponse indicating failure
                // return new LoginUserResponse(false, "User credentials not correct");
            }

            diary.setLocked(false);
            diaryRepository.save(diary);

            // Construct LoginUserResponse with appropriate parameters based on your response structure
            return new LoginUserResponse("Diary unlocked successfully");
        }

//        Optional<Diary> diary = diaryRepository.findDiaryByUserName(loginRequest.getUserName());
//        if (diary.isEmpty()) throw new IllegalArgumentException("Diary not found");
//        if (diary.get().getPassword().equals(loginRequest.getPassword())) diary.get().setLocked(false);
//        else throw new IllegalArgumentException("User credentials not correct");
//        diaryRepository.save(diary.get());
//        return new LoginUserResponse();
//        diaryRepository.save(diary.get());
//        return LoginUserResponse;
//        return null;


    @Override
    public Entry addEntry(CreateEntryRequest createEntryRequest) {
        Diary diary = validate(createEntryRequest.getUserName());
        Entry entry = entryService.addEntry(createEntryRequest);
        List<Entry> entries = entryService.findAllEntry(createEntryRequest.getUserName());

        diary.setEntries(entries);
        return entry;
    }

    private Diary validate(String userName) {
        Optional<Diary> foundDiary = diaryRepository.findDiaryByUserName(userName);
        if (foundDiary.isEmpty())
            throw new IllegalArgumentException("Diary is not found");
        if (foundDiary.get().isLocked())
            throw new IllegalArgumentException("Diary is Locked");
        return foundDiary.get();
    }

    @Override
    public void update(String userName, String oldPassword, String newPassword) {
        Diary diary = findByUserName(userName);
        if (diary.getPassword().equals(oldPassword))
            diary.setPassword(newPassword);
        else throw new IllegalArgumentException("Invalid Credentials");
    }

    @Override
    public Entry findEntry(String userName, String title) {
        Entry entry = entryService.findEntry(userName, title);
        return entry;
    }

}
