package com.example.ToDoProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponseDto {
    private long id;
    private String title;
    private int todo_order;
    private boolean completed;
}
