package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.EntryRepository;
import com.tatafo.dtos.request.CreateEntryRequest;
import com.tatafo.dtos.request.UpdateEntryRequest;
import com.tatafo.exceptions.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private EntryService entryService;




    @Override
    public void delete(String username, String title){
        Optional<Entry> foundEntry = entryRepository.findByUserNameAndTitle(username, title);
        if(foundEntry.isEmpty()) throw new EntryNotFoundException("Entry not found");
        entryRepository.delete(foundEntry.get());
    }
    public Entry findEntry(String userName, String title) {
        Optional<Entry> foundEntry = entryRepository.findByUserNameAndTitle(userName, title);
        if (foundEntry.isEmpty()) {
            throw new IllegalArgumentException("Entry not found");
        }
        return foundEntry.get();
}

    @Override
    public Entry updateEntry(UpdateEntryRequest updateEntryRequest) {
        Entry updatedEntry = new Entry();
        entryService.updateEntry()
        updatedEntry.setTitle(updateEntryRequest.getTitle());
        updatedEntry.setBody(updateEntryRequest.getBody());
        entryRepository.save(updatedEntry);
        return updatedEntry;
    }


    @Override
    public long count() {
        return entryRepository.count();
    }

    @Override
    public Entry addEntry(CreateEntryRequest createEntryRequest) {
        Entry newEntry = new Entry();
        newEntry.setUserName(createEntryRequest.getUserName());
        newEntry.setTitle(createEntryRequest.getTitle());
        newEntry.setBody(createEntryRequest.getBody());
        entryRepository.save(newEntry);
        return newEntry;
    }

    @Override
    public List<Entry> findAllEntry(String userName) {
        return entryRepository.findByUserName(userName);
    }
}
