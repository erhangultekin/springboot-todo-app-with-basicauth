package io.erhanboot.programming.todoapp.repository;

import io.erhanboot.programming.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
