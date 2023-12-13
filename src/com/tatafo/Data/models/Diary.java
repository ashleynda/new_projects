package com.tatafo.Data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Diary {

    @Id
    private String id;
    private String userName;
    private String password;
    public boolean isLocked;
    @DBRef
    private List<Entry> entries = new ArrayList<>();
//    private LocalDateTime registrationTime;

   }
