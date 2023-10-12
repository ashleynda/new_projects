package com.tatafo.services;

import com.tatafo.Data.models.Diary;
import com.tatafo.Data.models.Entry;

public interface EntryService {

    Diary findByUserName(String userName);
    void delete(String userName, String password);
    Entry addEntry(String userName, String title, String body);
    Entry findEntry(String userName, String title);
    long count();
}
