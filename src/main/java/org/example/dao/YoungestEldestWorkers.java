package org.example.dao;

import lombok.Data;

import java.time.LocalDate;

@Data
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;
}
