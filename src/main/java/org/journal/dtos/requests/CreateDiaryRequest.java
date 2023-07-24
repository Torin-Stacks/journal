package org.journal.dtos.requests;

import lombok.Data;

@Data
public class CreateDiaryRequest {
    private String username;
    private String diaryName;
}
