package io.erhanboot.programming.todoapp.controller;
import io.erhanboot.programming.todoapp.entity.Todo;
import io.erhanboot.programming.todoapp.entity.User;
import io.erhanboot.programming.todoapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/{userId}/list")
    public List<Todo> getList(@PathVariable Long userId){
        return userService.getList(userId);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId,@RequestBody Todo todo){
        userService.addTodo(userId,todo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
