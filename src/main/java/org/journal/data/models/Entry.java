package org.journal.data.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Entries")
public class Entry {
    @Id
    private String id;
    private String title;
    private String body;
    private String diaryId;
    @CreatedDate
    private LocalDateTime dateCreated;
}
