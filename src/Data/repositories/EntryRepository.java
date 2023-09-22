package Data.repositories;

import Data.models.Entry;

public interface EntryRepository {
    Entry save(Entry emtry
    );
    void delete(Entry diary);
    Entry findById(int i);
    Iterable <Entry> findAll();
    long count();
    void clear();
}
