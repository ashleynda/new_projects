package com.tatafo.Data.repositories;

import com.tatafo.Data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, String> {
    Optional<Diary> findByUserName(String userName);

}
