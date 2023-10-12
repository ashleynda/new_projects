package com.tatafo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryServiceImplTest {

    private EntryServiceImpl entryService;
    @BeforeEach
    public void startWithThis() {
        entryService = new EntryServiceImpl();
    }
    @Test
    public void entriesCanBeAddedTest(){
        entryService.addEntry("ownerName", "title", "body");
        assertEquals(1, entryService.count());
    }
    @Test
    public void EntryBelongingToUserCanBeDeletedTest(){
        entryService.addEntry("userName", "title", "body");
        entryService.addEntry("userName", "titleEntry", "body");
        assertEquals(2, entryService.count());
        entryService.delete("userName", "title");
        assertEquals(1, entryService.count());
    }
    @Test
    public void thatEntryCanThrowExceptionIfEntryIsNotFoundTest(){
        entryService.addEntry("userName", "title", "body");
        entryService.addEntry("userName", "titleEntry", "body");
        assertEquals(2, entryService.count());
        assertThrows(IllegalArgumentException.class,()->entryService.findEntry("userName","titles"));
    }
    @Test
    public void thatEntryCanThrowExceptionIfEntryDeletedIsNotFoundTest(){
        entryService.addEntry("username", "title", "body");
        entryService.addEntry("userName", "titleEntry", "body");
        assertEquals(2, entryService.count());
        assertThrows(IllegalArgumentException.class,()->entryService.delete("userName", "titles"));
    }

}