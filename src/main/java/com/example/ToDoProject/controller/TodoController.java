package com.example.ToDoProject.controller;

import com.example.ToDoProject.dto.TodoPatchDto;
import com.example.ToDoProject.dto.TodoPostDto;
import com.example.ToDoProject.entity.Todos;
import com.example.ToDoProject.mapper.TodoMapper;
import com.example.ToDoProject.service.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto){
        Todos todos = mapper.TodoPostToTodos(todoPostDto);
        todoService.createTodos(todos);
        return new ResponseEntity(mapper.TodosToResponse(todos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findTodo(@PathVariable("id") long id){
        Todos todo = todoService.getTodo(id);
        return new ResponseEntity(mapper.TodosToResponse(todo), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateTodo(@PathVariable("id") long id,
                                     @Valid @RequestBody TodoPatchDto todoPatchDto){
        todoPatchDto.setId(id);
        Todos updatedTodo = todoService.updateTodos(mapper.TodoPatchToTodos(todoPatchDto));
        return new ResponseEntity(mapper.TodosToResponse(updatedTodo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findsTodo(){
        List<Todos> todoList = todoService.getTodoList();
        return new ResponseEntity(mapper.TodoListToResponseList(todoList),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") long id){
        todoService.deleteTodo(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos(){
        todoService.deleteTodos();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
