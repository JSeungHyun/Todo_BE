package com.example.ToDoProject.service;

import com.example.ToDoProject.entity.Todos;
import com.example.ToDoProject.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class TodoService {

    private final TodosRepository todosRepository;

    public TodoService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public Todos createTodos(Todos todos){
        return todosRepository.save(todos);
    }

    public Todos updateTodos(Todos todos){
        Todos findTodo = findVerifiedTodos(todos.getId());
        Optional.ofNullable(todos.getTitle()).ifPresent(title -> findTodo.setTitle(title));
//        Optional.ofNullable(todos.getTodo_order()).ifPresent(o -> findTodo.setTodo_order(o));
        Optional.ofNullable(todos.getTodoOrder()).ifPresent(o -> findTodo.setTodoOrder(o));
        Optional.ofNullable(todos.getCompleted()).ifPresent(b -> findTodo.setCompleted(b));

        return todosRepository.save(findTodo);
    }

    public Todos getTodo(long id){
        return findVerifiedTodos(id);
    }

    public List<Todos> getTodoList(){
        return todosRepository.findAllByOrderByTodoOrderAsc();
    }

    public void deleteTodo(long id){
        Todos todo = findVerifiedTodos(id);
        todosRepository.delete(todo);
    }

    public void deleteTodos(){
        todosRepository.deleteAll();
    }
    private Todos findVerifiedTodos(long id){
        Optional<Todos> findTodo = todosRepository.findById(id);
        Todos todos = findTodo.orElseThrow(NoSuchElementException::new);
        return todos;
    }
}
