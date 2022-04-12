package io.erhanboot.programming.todoapp.config;
import io.erhanboot.programming.todoapp.entity.Todo;
import io.erhanboot.programming.todoapp.entity.User;
import io.erhanboot.programming.todoapp.repository.TodoRepository;
import io.erhanboot.programming.todoapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class UserConfig {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public UserConfig(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

            User user=new User();
            user.setPassword("squdududududubangg");
            user.setUsername("Erhan");

            Todo todo=new Todo();
            todo.setContent("check the pay");

            todo.setUser(user);



            user.getTodoList().add(todo);
            userRepository.save(user);
            todoRepository.save(todo);

        };


    }
}
