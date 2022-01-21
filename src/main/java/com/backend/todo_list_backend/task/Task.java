package com.backend.todo_list_backend.task;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class Task {
    
    @Id
    private String id;
    private String name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public Task(String name, LocalDateTime created_at, LocalDateTime updated_at) {
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


}
