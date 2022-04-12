package io.erhanboot.programming.todoapp.repository;

import io.erhanboot.programming.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
