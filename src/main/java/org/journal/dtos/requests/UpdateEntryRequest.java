package org.journal.dtos.requests;

import lombok.Data;

@Data
public class UpdateEntryRequest {
    private String title;
    private String body;
}
