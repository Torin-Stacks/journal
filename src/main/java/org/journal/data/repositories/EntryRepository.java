package org.journal.data.repositories;

import org.journal.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
    Entry findByTitleAndDiaryId(String title);

    List<Entry> findAllByDiaryId(String diaryId);
}
