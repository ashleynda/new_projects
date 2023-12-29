package com.tatafo.services;

import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.EntryRepository;
import com.tatafo.dtos.request.DeleteEntryRequest;
import com.tatafo.dtos.response.UpdateEntryResponse;
import com.tatafo.dtos.request.CreateEntryRequest;
import com.tatafo.dtos.request.UpdateEntryRequest;
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

    public Entry findEntry(String userName, String title) {
        Entry foundEntry = entryRepository.findByOwnerNameAndTitle(userName, title).get();
        boolean entryNotFound = foundEntry == null;
        if (entryNotFound) throw new IllegalArgumentException("Entry not found");
        return foundEntry;

    }

    @Override
    public UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest) {
        Entry foundEntry = findEntry(updateEntryRequest.getOwnerName(), updateEntryRequest.getTitle());
        foundEntry.setTitle(updateEntryRequest.getNewTitle());
        foundEntry.setBody(updateEntryRequest.getBody());

        Entry savedEntry = entryRepository.save(foundEntry);

        UpdateEntryResponse updateEntryResponse = new UpdateEntryResponse();
        updateEntryResponse.setMessage("Successfully Updated");
        updateEntryResponse.setStatus("ok");
        updateEntryResponse.setUpdateEntry(savedEntry);
        return updateEntryResponse;

    }

    @Override
    public String deleteEntry(DeleteEntryRequest deleteEntryRequest) {
        Entry foundEntry = findEntry(deleteEntryRequest.getOwnerName(), deleteEntryRequest.getTitle());
        entryRepository.delete(foundEntry);
        return "Entry deleted Successfully";
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
