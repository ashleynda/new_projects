package com.tatafo.Data.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Diary {

    private int id;
    private String userName;
    private String password;
    private String isLocked;
    private List<Entry> entries = new ArrayList<>();
    private LocalDateTime registrationTime;
}
