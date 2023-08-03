package org.journal.services;

import org.journal.data.models.Entry;
import org.journal.dtos.requests.CreateEntryRequest;
import org.journal.dtos.requests.UpdateEntryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryServices {
    void createEntry(CreateEntryRequest createEntryRequest);

    void updateEntry(String entryId, UpdateEntryRequest updateEntryRequest);

    List<Entry> getDiaryEntries(String diaryId);

    void deleteEntry(String entryId);

    Entry getDiaryEntry(String entryId);
}
