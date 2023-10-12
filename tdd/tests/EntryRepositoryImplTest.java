package tests;

import com.tatafo.Data.models.Entry;
import com.tatafo.Data.repositories.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntryRepositoryImplTest  {
    private EntryRepositoryImpl entryRepository;

    @BeforeEach
    public void startWithThis() {
        entryRepository = new EntryRepositoryImpl();
    }

    @Test
    public void saveOneEntry_CountIsOneTest() {
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1, entryRepository.count());
    }
    @Test
    public void saveOneEntry_FindByIdTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1, entryRepository.count());
        assertEquals(entry, entryRepository.findById(1));
    }
    @Test
    public void updateEntryTest() {
        Entry entry = new Entry();
        entry.setOwnerName("esther");
        entryRepository.save(entry);

        Entry updateEntry = new Entry();
        updateEntry.setId(1);
        updateEntry.setOwnerName("americana");
        entryRepository.save(updateEntry);
        assertEquals("americana", entryRepository.findById(1).getOwnerName());
        assertEquals(1, entryRepository.count());
    }
    @Test
    public void deleteOneEntry_ReduceCountBy1Test() {
        Entry entry = new Entry();
        entry.setOwnerName("Tomide");
        entryRepository.save(entry);

        Entry updateEntry = new Entry();
        entryRepository.save(updateEntry);
        entryRepository.delete(updateEntry);
        assertEquals(1, entryRepository.count());
    }
    @Test
    public void findEntryDeletedTest() {
        Entry entry = new Entry();
        entry.setOwnerName("Tomide");
        entryRepository.save(entry);

        Entry updateEntry = new Entry();
        entryRepository.save(updateEntry);
        entryRepository.delete(updateEntry);
        assertNull(entryRepository.findById(2));
    }
    @Test
    public void findAllEntryTest() {
        Entry entry = new Entry();
        entry.setOwnerName("Tomide");
        entryRepository.save(entry);

        Entry updateEntry = new Entry();
        updateEntry.setOwnerName("americana");
        entryRepository.save(updateEntry);
        Iterable<Entry> all_diaries = List.of(new Entry[]{entry, updateEntry});
        assertEquals(all_diaries, entryRepository.findAll());
    }
    @Test
    public void clearAllEntryTest() {
        Entry entry = new Entry();
        entry.setOwnerName("Tomide");
        entryRepository.save(entry);

        Entry updateEntry = new Entry();
        entryRepository.save(updateEntry);
        entryRepository.clear();
        assertEquals(0, entryRepository.count());



    }

}
