package com.tatafo.Data.models;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Entry{
    private int id;
    private String title;
    private String body;

    private String ownerName;
    private LocalDateTime timeCreated = LocalDateTime.now();
}
