package org.journal.services;

import org.journal.data.models.Diary;
import org.journal.data.models.User;
import org.journal.data.repositories.DiaryRepository;
import org.journal.dtos.requests.CreateDiaryRequest;
import org.journal.dtos.requests.DeleteDiaryRequest;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
        diary.setName(diaryName);
        diary.setUsername(existingUser.getUsername());
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

        List<Diary> foundDiaries = diaryRepository.findByUsername(username);
        System.out.println(foundDiaries);
        for(Diary diary : foundDiaries){
            if(diary.getName().equals(diaryName)){
                return diary;
            }
        }
         throw new IllegalArgumentException("diary does not exist");
    }

}

//if(diary != null && diary.getUsername().equals(deleteDiaryRequest.getUsername())){diaryRepository.delete(diary);}
