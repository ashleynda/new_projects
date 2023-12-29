package com.tatafo.dtos.response;

import com.tatafo.Data.models.Entry;
import lombok.Data;

@Data
public class UpdateEntryResponse {

    private String status;
    private String message;
    private Entry updateEntry;
}
