package com.example.ToDoProject.mapper;


import com.example.ToDoProject.dto.TodoPatchDto;
import com.example.ToDoProject.dto.TodoPostDto;
import com.example.ToDoProject.dto.TodoResponseDto;
import com.example.ToDoProject.entity.Todos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    @Mapping(source = "todo_order", target = "todoOrder")
    Todos TodoPostToTodos(TodoPostDto todoPostDto);
    @Mapping(source = "todo_order", target = "todoOrder")
    Todos TodoPatchToTodos(TodoPatchDto todoPatchDto);
    @Mapping(source = "todoOrder", target = "todo_order")
    TodoResponseDto TodosToResponse(Todos todos);
    @Mapping(source = "todoOrder", target = "todo_order")
    List<TodoResponseDto> TodoListToResponseList(List<Todos> todos);
}
