package org.journal.services;

import org.journal.data.models.Diary;
import org.journal.dtos.requests.CreateDiaryRequest;
import org.journal.dtos.requests.DeleteDiaryRequest;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.journal.dtos.responses.FindDiariesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DiaryServices {
    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);

    void deleteDiary(String id, String username);

    Diary findDiary(String username, String diaryName);


    List<Diary> findAllDiariesByUsername(String username);
}
