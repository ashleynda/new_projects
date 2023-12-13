package com.tatafo.dtos.request;

import lombok.Data;

@Data
public class CreateEntryRequest {
    private String userName;
    private String title;
    private String body;
}
