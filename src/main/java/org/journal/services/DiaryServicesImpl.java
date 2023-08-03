package org.journal.services;

import org.journal.data.models.Diary;
import org.journal.data.models.User;
import org.journal.data.repositories.DiaryRepository;
import org.journal.dtos.requests.CreateDiaryRequest;
import org.journal.dtos.requests.DeleteDiaryRequest;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.journal.dtos.responses.FindDiariesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DiaryServicesImpl implements DiaryServices {
    @Autowired
    DiaryRepository diaryRepository;
    @Autowired

    private UserServices userServices;

    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        Diary diary = new Diary();
        User existingUser = validateUserName(createDiaryRequest.getUsername());
        String diaryName = validateDairyName(createDiaryRequest.getDiaryName());
        System.out.println(diaryName + " ------------------------------------------");
        diary.setName(diaryName);
        diary.setUsername(existingUser.getUsername());
        System.out.println(diary + " ==============================================================");
        diaryRepository.save(diary);


        CreateDiaryResponse createDiaryResponse = new CreateDiaryResponse();
        createDiaryResponse.setCreateDiaryInfo("Diary Successfully created");

        return  createDiaryResponse;
    }

    private User validateUserName(String username) {
        User user = userServices.findByUsername(username);
        if(user == null){
            throw new IllegalArgumentException("user does not exist create an account");
        }
        return user;
    }

    private String validateDairyName(String diaryName) {
        Diary diary = diaryRepository.findByName(diaryName);
        if(diary == null){
            return diaryName;
        }
        else throw  new IllegalArgumentException("Diary Name already exists");
    }

    @Override
    public void deleteDiary(String id, String username) {
      List<Diary> foundDiaries = diaryRepository.findByUsername(username);
      for(Diary diary: foundDiaries){
          if(diary.getId().equals(id)){
              diaryRepository.delete(diary);
          }
      }
      throw new IllegalArgumentException("User does not exist ");

    }

    @Override
    public Diary findDiary(String username, String diaryName) {
        Diary foundDiary = diaryRepository.findByUsernameAndName(username, diaryName);

        if (foundDiary == null) {
            throw new IllegalArgumentException("diary does not exist");
        }
        return foundDiary;
    }

    @Override
    public FindDiariesResponse findAllDiariesByUsername(String username) {
        return diaryRepository.findByUsername(username);
    }


}


