package io.erhanboot.programming.todoapp.service;

import io.erhanboot.programming.todoapp.entity.Todo;
import io.erhanboot.programming.todoapp.entity.User;
import io.erhanboot.programming.todoapp.repository.TodoRepository;
import io.erhanboot.programming.todoapp.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;


    public UserService(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }


    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void addTodo(Long userId,Todo todo){
        User user=userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        user.getTodoList().add(todo);
        todoRepository.save(todo);

    }

    public void deleteUser(Long userId){
        User user=userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        userRepository.delete(user);
    }

    public List<Todo> getList(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return user.getTodoList();
    }


}
