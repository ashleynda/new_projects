package com.tatafo.Data.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Entry{
    @Id
    private String id;
    private String title;
    private String body;

    private String userName;
    private LocalDateTime timeCreated = LocalDateTime.now();
}
