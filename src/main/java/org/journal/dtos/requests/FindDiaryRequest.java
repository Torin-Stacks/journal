package org.journal.dtos.requests;

import lombok.Data;

@Data
public class FindDiaryRequest {
    private String name;
    private String id;
}
