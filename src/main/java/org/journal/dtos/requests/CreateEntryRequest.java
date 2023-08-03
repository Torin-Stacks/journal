package org.journal.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Data
public class CreateEntryRequest {
    private String id;
    private String title;
    private String body;
    private String diaryId;

    @CreatedDate
    private LocalDateTime dateCreated;

}
