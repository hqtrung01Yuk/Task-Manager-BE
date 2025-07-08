package com.learn.task.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.learn.task.dto.SignupRequest;
import com.learn.task.dto.UserDto;
import com.learn.task.entities.User;
import com.learn.task.enums.UserRole;
import com.learn.task.repositories.UserRepository;
import com.learn.task.services.AuthService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public UserDto signupUser(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.EMPLOYEE);

        User userSaved = userRepository.save(user);

        logger.info("User signed up successfully with name: {}", userSaved.getName());

        return userSaved.getUserDto();
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    // @PostConstruct
    // public void createAnAdminAccount() {
    // logger.info("Checking if ADMIN user already exists...");

    // if (userRepository.existsByUserRole(UserRole.ADMIN)) {
    // logger.info("ADMIN user already exists. Skipping creation.");
    // return;
    // }

    // logger.info("ADMIN user not found. Creating default admin account...");
    // User admin = new User();
    // admin.setEmail("admin@test.com");
    // admin.setName("admin");
    // admin.setPassword(passwordEncoder.encode("123456"));
    // admin.setUserRole(UserRole.ADMIN);

    // userRepository.save(admin);
    // logger.info("Default ADMIN user created successfully.");
    // }
}
