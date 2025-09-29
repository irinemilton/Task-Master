package com.taskmaster.service;
import com.taskmaster.dto.UserDto;
import com.taskmaster.entity.User;
import com.taskmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.secret.key}") private String adminSecretKey;

    public UserService(UserRepository u, PasswordEncoder p) { this.userRepository = u; this.passwordEncoder = p; }
    public Optional<User> findByUsername(String u) { return userRepository.findByUsername(u); }
    public void saveUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        if ("ADMIN".equals(dto.getRole())) {
            if (!adminSecretKey.equals(dto.getAdminSecretKey())) throw new IllegalArgumentException("Invalid Admin Secret Key.");
            user.setRoles(Collections.singleton("ROLE_ADMIN"));
        } else {
            user.setRoles(Collections.singleton("ROLE_USER"));
        }
        userRepository.save(user);
    }
}