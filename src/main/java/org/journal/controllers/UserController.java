package org.journal.controllers;

import org.journal.data.models.Diary;
import org.journal.dtos.requests.*;
import org.journal.dtos.responses.*;
import org.journal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

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

   @GetMapping("/findDiary/{username}")
    public Diary findDiary(@PathVariable String username, @RequestParam String diaryName ){
        return userServices.findDiaryByName(username, diaryName);
   }

    @GetMapping("/findAllDiary/{username}")
    public FindDiariesResponse findAllDiary(@PathVariable String username){
        return  userServices.findAllDiaryByUsername(username); // ask how to mapping a list to the findDiariesResponse
    }

}
