package org.journal.services;

import lombok.RequiredArgsConstructor;
import org.journal.data.models.Entry;
import org.journal.data.repositories.EntryRepository;
import org.journal.dtos.requests.CreateEntryRequest;
import org.journal.dtos.requests.UpdateEntryRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryServicesImpl implements EntryServices {
private  final  EntryRepository entryRepository;
    @Override
    public void createEntry(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        String title = validateTitle(createEntryRequest.getTitle(), createEntryRequest.getDiaryId());
        entry.setTitle(title);
        entry.setBody(createEntryRequest.getBody());
        entry.setDateCreated(LocalDateTime.now());

        entryRepository.save(entry);

    }
    private String validateTitle(String title,String diaryId) {
        Entry foundEntry = entryRepository.findByTitleAndDiaryId(title);
        if(foundEntry==null){ return title;}
        else throw new IllegalArgumentException("pls use a different title for your entry");
    }

    @Override
    public void updateEntry(String entryId, UpdateEntryRequest updateEntryRequest) {
        Entry foundEntry = entryRepository.findById(entryId).orElseThrow(RuntimeException::new);
        BeanUtilHelper.copyPropertiesIgnoreNull(updateEntryRequest, foundEntry);
        foundEntry.setDateCreated(LocalDateTime.now());
        entryRepository.save(foundEntry);
    }
    @Override
    public List<Entry> getDiaryEntries(String diaryId) {
        return entryRepository.findAllByDiaryId(diaryId);
    }

    @Override
    public void deleteEntry(String entryId) {
        Entry foundEntry = entryRepository.findById(entryId).orElseThrow(RuntimeException::new);
        entryRepository.delete(foundEntry);

    }


}
