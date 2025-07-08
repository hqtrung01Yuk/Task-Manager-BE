package com.learn.task.services;

import com.learn.task.dto.*;

public interface AuthService {
    UserDto signupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
