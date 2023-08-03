package org.journal.dtos.responses;

import lombok.Data;
import org.journal.data.models.Diary;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
public class FindDiariesResponse {
    private List<Diary> diaries;
}
