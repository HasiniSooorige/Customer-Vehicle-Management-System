package com.crudproject.CRUD_Spring.service;

import com.crudproject.CRUD_Spring.entity.User;
import com.crudproject.CRUD_Spring.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Login validation
    public User loginUser(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Compare encrypted password
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user; // login success
            }
        }
        return null; // invalid credentials
    }
}
