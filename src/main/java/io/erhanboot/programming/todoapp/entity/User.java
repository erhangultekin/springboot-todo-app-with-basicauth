package io.erhanboot.programming.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name="id_generator", sequenceName = "id_seq", allocationSize=50)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonManagedReference
    private List<Todo> todoList=new ArrayList<>();

    public User() {
    }

    public User(String username, String password, List<Todo> todoList) {
        this.username = username;
        this.password = password;
        this.todoList = todoList;
    }

    public Todo getTodo(Long todoId){
        for(Todo todo: todoList){
            if(todo.getId().equals(todoId)){
                return todo;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

}
