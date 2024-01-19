package com.tatafo.services;

import com.tatafo.Data.models.Entry;
import com.tatafo.dtos.request.DeleteEntryRequest;
import com.tatafo.dtos.response.UpdateEntryResponse;
import com.tatafo.dtos.request.CreateEntryRequest;
import com.tatafo.dtos.request.UpdateEntryRequest;

import java.util.List;

public interface EntryService {

    void delete(String userName, String password);
    long count();

    Entry addEntry(CreateEntryRequest createEntryRequest);

    List<Entry> findAllEntry(String userName);

    Entry findEntry(String userName, String title);

//    List<Entry> findEntries(String title, String username);

    UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest);

    String deleteEntry(DeleteEntryRequest deleteEntryRequest);
}


