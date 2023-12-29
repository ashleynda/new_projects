package com.tatafo.dtos.request;

import lombok.Data;

@Data
public class DeleteEntryRequest {

    private String ownerName;
    private String title;

}
