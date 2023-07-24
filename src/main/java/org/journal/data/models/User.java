package org.journal.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Users")
public class User {
    private String username;
    private String password;
    private boolean isLoggedIn;
    @Id
    private String id;


}
