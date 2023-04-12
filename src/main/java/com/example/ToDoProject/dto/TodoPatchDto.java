package com.example.ToDoProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TodoPatchDto {
    private long id;
    private String title;
    private Integer todo_order;

    private Boolean completed;

    public void setId(long id) {
        this.id = id;
    }
}
