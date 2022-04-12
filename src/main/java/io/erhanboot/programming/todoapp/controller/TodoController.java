package io.erhanboot.programming.todoapp.controller;


import io.erhanboot.programming.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/v1/users/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("{userId}/{todoId}")
    public void completedTodo(@PathVariable Long todoId,@PathVariable Long userId){
        todoService.completedTodo(todoId,userId);
    }

    @DeleteMapping("{userId}/{todoId}")
    public void deleteTodo(@PathVariable Long todoId,@PathVariable Long userId){
        todoService.deleteTodo(todoId,userId);
    }

}
