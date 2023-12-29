package com.tatafo.dtos.request;


import lombok.Data;

@Data
public class UpdateEntryRequest {

    private String ownerName;
    private String title;
    private  String newTitle;
    private String body;
}

