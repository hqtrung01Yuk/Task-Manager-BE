package com.learn.task.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.learn.task.entities.User;
import com.learn.task.enums.UserRole;
import com.learn.task.repositories.UserRepository;

public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Override
    public void run(String... args) {
        logger.info("Checking if ADMIN user already exists...");

        if (userRepository.existsByUserRole(UserRole.ADMIN)) {
            logger.info("ADMIN user already exists. Skipping creation.");
            return;
        }

        logger.info("ADMIN user not found. Creating default admin account...");
        User admin = new User();
        admin.setEmail("admin@test.com");
        admin.setName("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setUserRole(UserRole.ADMIN);

        userRepository.save(admin);
        logger.info("Default ADMIN user created successfully.");
    }
}
