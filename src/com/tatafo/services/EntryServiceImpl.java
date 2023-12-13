package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.EntryRepository;
import com.tatafo.dtos.request.CreateEntryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;


    @Override
    public void delete(String userName, String title) {
        Entry entry = entryRepository.findByOwnerNameAndTitle(userName, title).get();
        entryRepository.delete(entry);

    }

//    @Override
//    public Entry addEntry(String userName, String title, String body) {
//        Entry newEntry = new Entry();
//        newEntry.setOwnerName(userName);
//        newEntry.setTitle(title);
//        newEntry.setBody(body);
//        entryRepository.save(newEntry);
//        return newEntry;
//    }

    public Entry findEntry(String userName, String title) {
        Entry foundEntry = entryRepository.findByOwnerNameAndTitle(userName, title).get();
        boolean entryNotFound = foundEntry == null;
        if (entryNotFound) throw new IllegalArgumentException("Entry not found");
        return foundEntry;

    }

    @Override
    public long count() {
        return entryRepository.count();
    }

    @Override
    public Entry addEntry(CreateEntryRequest createEntryRequest) {
        Entry newEntry = new Entry();
        newEntry.setOwnerName(createEntryRequest.getUserName());
        newEntry.setTitle(createEntryRequest.getTitle());
        newEntry.setBody(createEntryRequest.getBody());
        entryRepository.save(newEntry);
        return newEntry;
    }

    @Override
    public List<Entry> findAllEntry(String userName) {
        return entryRepository.findByOwnerName(userName);
    }
}
