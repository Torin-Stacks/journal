package org.journal.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(value ="Diaries")
public class Diary {
    @Id
    private String id;
    private String name;
    private String username;
    private List<User> listOfUser = new ArrayList<>();
}
