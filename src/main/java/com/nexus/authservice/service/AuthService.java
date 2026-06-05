package com.nexus.authservice.service;

import com.nexus.authservice.model.User;
import com.nexus.authservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // BCrypt cost factor 12 — as required by the backend plan
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public User register(String email, String rawPassword, String fullName, String indexNumber) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(rawPassword)); // HASHED — never plain text
        user.setFullName(fullName);
        user.setIndexNumber(indexNumber);
        user.setPreferredLanguage("en");
        user.setSignDialect("ASL");
        user.setMedicalPreferences("{}");

        return userRepository.save(user);
    }

    public User login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found!"));

        // BCrypt comparison — never .equals() on hashed passwords
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid password!");
        }

        return user;
    }
}
