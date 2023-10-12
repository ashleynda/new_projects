package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.EntryRepository;
import com.tatafo.Data.repositories.EntryRepositoryImpl;


public class EntryServiceImpl implements EntryService {
    private EntryRepository entryRepository = new EntryRepositoryImpl();

    @Override
    public Diary findByUserName(String userName) {
        return null;
    }

    @Override
    public void delete(String userName, String title) {
        Entry entry = findEntry(userName, title);
        entryRepository.delete(entry);

    }

//    private Entry findEntry(String userName, String title) {
//        Entry foundEntry = entryRepository.findUserName(userName, title);
//        boolean entryNotFound = foundEntry == null;
//        if (entryNotFound) throw new IllegalArgumentException("Entry not found");
//        return foundEntry;
//    }

    @Override
    public Entry addEntry(String userName, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setOwnerName(userName);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        entryRepository.save(newEntry);
        return newEntry;
    }

    public Entry findEntry(String userName, String title) {
        Entry foundEntry = entryRepository.findUserName(userName, title);
        boolean entryNotFound = foundEntry == null;
        if (entryNotFound) throw new IllegalArgumentException("Entry not found");
        return foundEntry;

    }

    @Override
    public long count() {
        return entryRepository.count();
    }
}
