package com.learn.task.services.admin.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.learn.task.dto.UserDto;
import com.learn.task.entities.User;
import com.learn.task.enums.UserRole;
import com.learn.task.repositories.UserRepository;
import com.learn.task.services.admin.AdminService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE).map(User::getUserDto)
                .collect(Collectors.toList());
    }

}
