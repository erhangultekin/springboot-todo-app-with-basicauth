package io.erhanboot.programming.todoapp.service;

import io.erhanboot.programming.todoapp.entity.Todo;
import io.erhanboot.programming.todoapp.entity.User;
import io.erhanboot.programming.todoapp.repository.TodoRepository;
import io.erhanboot.programming.todoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public void completedTodo(Long todoId,Long userId){
        User user=userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Todo todo=user.getTodo(todoId);
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId,Long userId){
        User user=userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Todo todo=user.getTodo(todoId);
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }
}
