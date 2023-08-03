package org.journal.controllers;

import lombok.RequiredArgsConstructor;
import org.journal.data.models.Entry;
import org.journal.dtos.requests.CreateEntryRequest;
import org.journal.dtos.requests.UpdateEntryRequest;
import org.journal.services.EntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entries")
@RequiredArgsConstructor
public class EntryController {
private final EntryServices entryServices;
@PostMapping("createentry/{diaryId}")
    public void createEntry(@PathVariable String diaryId, @RequestBody CreateEntryRequest createEntryRequest){
        entryServices.createEntry(createEntryRequest);
    }

    @PatchMapping("updateentry/{entryId}")
    public void updateEntry(@PathVariable String entryId, @RequestBody UpdateEntryRequest updateEntryRequest){
    entryServices.updateEntry(entryId,updateEntryRequest);
    }


    @GetMapping("/{diaryId}")
    public ResponseEntity<List<Entry>> getDiaryEntries(@PathVariable String diaryId){
       return new ResponseEntity<>(entryServices.getDiaryEntries(diaryId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteentry/{entryId}")
    public void deleteEntry(@PathVariable String entryId){entryServices.deleteEntry(entryId);}
}
