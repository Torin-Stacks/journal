package org.journal.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class CreateUserRequest {
    private String username;
    private String password;
    private String id;
}
