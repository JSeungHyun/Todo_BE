package com.example.ToDoProject.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class TodoPostDto {

    @NotBlank(message = "이름을 입력하세요")
    private String title;
    @NotNull(message = "순서를 지정하세요")
    private int todo_order;
    @NotNull(message = "완료 여부를 입력하세요")
    private boolean completed;
}
