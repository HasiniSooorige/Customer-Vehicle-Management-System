package com.crudproject.CRUD_Spring.repository;

import com.crudproject.CRUD_Spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
