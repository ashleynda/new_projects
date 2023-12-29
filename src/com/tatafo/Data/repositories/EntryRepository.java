package com.tatafo.Data.repositories;

import com.tatafo.Data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
    Optional<Entry> findByUserNameAndTitle(String userName, String title);
    List<Entry> findByUserName(String userName);
    Optional<Entry> findById(String id);

//    Optional<Entry> findEntryByOwnernameAndTitle(String username, String title);
}
