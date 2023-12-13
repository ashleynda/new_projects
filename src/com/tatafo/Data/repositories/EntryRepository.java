package com.tatafo.Data.repositories;

import com.tatafo.Data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
    Optional<Entry> findByOwnerNameAndTitle(String ownerName, String title);

    List<Entry> findByOwnerName(String userName);
}
