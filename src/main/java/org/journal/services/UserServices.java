package org.journal.services;

import org.journal.data.models.Diary;
import org.journal.data.models.User;
import org.journal.dtos.requests.*;
import org.journal.dtos.responses.ChangePasswordResponse;
import org.journal.dtos.responses.CreateDiaryResponse;
import org.journal.dtos.responses.CreateUserResponse;
import org.journal.dtos.responses.LoginResponse;
import org.springframework.stereotype.Service;

public interface UserServices {
    CreateUserResponse register(CreateUserRequest createUserRequest);

    LoginResponse login(LoginRequest loginRequest);

    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);

    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);

//    void deleteDiary(DeleteDiaryRequest deleteDiaryRequest);
       void deleteDiary(String id,String username);



    Diary findDiaryByName(String username,String DiaryName);

    User findByUsername(String username);
}
