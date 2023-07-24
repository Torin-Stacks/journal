package org.journal.controllers;

import org.journal.data.models.Diary;
import org.journal.dtos.requests.*;
import org.journal.dtos.responses.ChangePasswordResponse;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.journal.dtos.responses.CreateUserResponse;
import org.journal.dtos.responses.LoginResponse;
import org.journal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/registerUser")
    public CreateUserResponse register(@RequestBody CreateUserRequest createUserRequest){
        return userServices.register(createUserRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return userServices.login(loginRequest);
    }

    @PatchMapping("/changePassword")
    public ChangePasswordResponse changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        return userServices.changePassword( changePasswordRequest);
    }
    @PostMapping("/createDiary")
    public CreateDiaryResponse createDiary(@RequestBody CreateDiaryRequest createDiaryRequest){
        return userServices.createDiary(createDiaryRequest);
    }

    @DeleteMapping("/deleteDiary/{id}/{username}")
    public void deleteDiary(@PathVariable String id, @PathVariable String username){
        userServices.deleteDiary(id,username);
    }

//   @DeleteMapping("/deleteDiary/{id}")
//    public void deleteDiary(@RequestBody DeleteDiaryRequest deleteDiaryRequest){
//        userServices.deleteDiary(deleteDiaryRequest);
//   }

   @GetMapping("/findDiary/{username}")
    public Diary findDiary(@PathVariable String username, @RequestBody String diaryName ){
        return userServices.findDiaryByName(username, diaryName);
   }

}
