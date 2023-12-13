package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;
import com.tatafo.dtos.request.CreateEntryRequest;

import java.util.List;

public interface EntryService {

    void delete(String userName, String password);
    long count();

    Entry addEntry(CreateEntryRequest createEntryRequest);

    List<Entry> findAllEntry(String userName);

    Entry findEntry(String userName, String title);
}


