package org.journal.services;

import org.journal.data.models.Diary;
import org.journal.data.models.User;
import org.journal.data.repositories.UserRepository;
import org.journal.dtos.requests.*;
import org.journal.dtos.responses.ChangePasswordResponse;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.journal.dtos.responses.CreateUserResponse;
import org.journal.dtos.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImplementation implements UserServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DiaryServices diaryServices;

    @Override
    public CreateUserResponse register(CreateUserRequest createUserRequest) {
        User user = new User();
        String username = validateUsername(createUserRequest.getUsername());
        user.setUsername(username);
        user.setPassword(createUserRequest.getPassword());
        userRepository.save(user);

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setResponseInfo("successfully registered");

        return createUserResponse;
    }
    private String validateUsername(String username){
        User foundUser = userRepository.findByUsername(username);
        if (foundUser!= null){
            throw new IllegalArgumentException("username already exists");
        }
        return username;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(user.getPassword().equals(loginRequest.getPassword())){
            user.setLoggedIn(true);
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setLoginInfo("you are have successfully logged in");
            return loginResponse;
        }
                throw new IllegalArgumentException("username or password incorrect");
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(changePasswordRequest.getUsername());
        if(user.getPassword().equals(changePasswordRequest.getOldPassword())){
            user.setUsername(changePasswordRequest.getNewPassword());
            userRepository.save(user);
            ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
            changePasswordResponse.setResponseInfo("login with your new password");
            return changePasswordResponse;
        }
        throw new IllegalArgumentException("username or password does not exist");
    }

    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        return diaryServices.createDiary(createDiaryRequest);
    }

    @Override
    public void deleteDiary(String id, String username) {
        diaryServices.deleteDiary(id,username);
    }

    @Override
    public Diary findDiaryByName(String username, String diaryName) {
        return diaryServices.findDiary(username,diaryName);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


//    @Override
//    public Diary findDiaryByName() {
//        return null;
//    }


}
