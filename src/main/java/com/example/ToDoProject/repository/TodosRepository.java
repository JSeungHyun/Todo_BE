package com.example.ToDoProject.repository;

import com.example.ToDoProject.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {
    List<Todos> findAllByOrderByTodoOrderAsc();
}
