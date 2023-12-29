package com.tatafo.dtos.request;

import lombok.Data;

@Data
public class UpdateEntryRequest {
    private String oldTitle;
    private String title;
    private String body;
}
