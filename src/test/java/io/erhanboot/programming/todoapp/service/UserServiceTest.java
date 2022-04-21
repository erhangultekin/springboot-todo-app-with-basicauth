package io.erhanboot.programming.todoapp.service;

import io.erhanboot.programming.todoapp.entity.Todo;
import io.erhanboot.programming.todoapp.entity.User;
import io.erhanboot.programming.todoapp.repository.TodoRepository;
import io.erhanboot.programming.todoapp.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {



    private UserService underTest;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    @BeforeEach
    public void setUp() throws Exception{
        userRepository= Mockito.mock(UserRepository.class);
        todoRepository= Mockito.mock(TodoRepository.class);

        underTest= new UserService(userRepository,todoRepository);
    }

    @Test
    void whenCreateUserWithCalledValidParameter_itShouldReturnValid() {
        User user = new User();
        List<Todo> testList = new ArrayList<>();
        user.setId(1L);
        user.setUsername("Erhan");
        user.setPassword("12345");
        user.setTodoList(testList);

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = underTest.getUserById(1L);

        assertEquals(result, user);

    }

    @Test
    public void whenUserIdDoesNotExist_shouldReturnUserNotFoundException(){

        Mockito.when(userRepository.findById(10L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,()->underTest.getUserById(10L));

    }




}