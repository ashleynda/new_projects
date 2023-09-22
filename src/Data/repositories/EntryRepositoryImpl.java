package Data.repositories;

import Data.models.Diary;
import Data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private List<Entry> entries = new ArrayList<>();

    @Override
    public Entry save(Entry entry) {
        if (entry.getId() == 0) newSave(entry);
        else update(entry);
        return entry;
    }

    private void newSave(Entry entry) {
        entry.setId(generateId());
        entries.add(entry);
    }

    private void update(Entry entry) {
        Entry newEntry = findById(entry.getId());
        newEntry.setOwnerName(entry.getOwnerName());
    }

    @Override
    public void delete(Entry diary) {
        Entry foundD = findById(diary.getId());
        entries.remove(foundD);

    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries){
            if (entry.getId() == id) return entry;
        }
        return null;
    }

    @Override
    public Iterable<Entry> findAll() {
        return entries;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void clear() {
        entries.clear();
    }
    private int generateId() {
        return entries.size() + 1;
    }
}
