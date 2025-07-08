package com.learn.task.controller.auth;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.task.dto.*;
import com.learn.task.entities.User;
import com.learn.task.repositories.UserRepository;
import com.learn.task.services.AuthService;
import com.learn.task.services.UserService;
import com.learn.task.services.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        if (authService.hasUserWithEmail(signupRequest.getEmail())) {
            logger.warn("User already exist with this email");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("User already exist with this email");
        }

        UserDto createuUserDto = authService.signupUser(signupRequest);
        if (createuUserDto == null) {
            logger.warn("User no created");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User no created");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createuUserDto);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(), authenticationRequest.getPassword()));
            logger.info("Authentication successful for email: {}",
                    authenticationRequest.getEmail());

            final UserDetails userDetails = userService.userDetailsService()
                    .loadUserByUsername(authenticationRequest.getEmail());
            Optional<User> optionalUser =
                    userRepository.findFirstByEmail(authenticationRequest.getEmail());
            // System.out.println("User found: " + optionalUser.isPresent());
            // User user = optionalUser.get();
            // System.out.println("Raw: " + authenticationRequest.getPassword());
            // System.out.println("Encoded in DB: " + user.getPassword());
            // System.out.println("Match? " + passwordEncoder
            // .matches(authenticationRequest.getPassword(), user.getPassword()));

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            if (optionalUser.isPresent()) {
                final String jwtToken = jwtUtil.generateToken(userDetails);
                authenticationResponse.setJwt(jwtToken);
                authenticationResponse.setUserId(optionalUser.get().getId());
                authenticationResponse.setUserRole(optionalUser.get().getUserRole());
                logger.info("JWT generated and login response created for user id: {}",
                        optionalUser.get().getId());
            } else {
                logger.warn("User not found after authentication for email: {}",
                        authenticationRequest.getEmail());
            }

            return authenticationResponse;
        } catch (BadCredentialsException e) {
            // TODO: handle exception
            logger.warn("Authentication failed for email: {}", authenticationRequest.getEmail());
            throw new BadCredentialsException("Incorrect username and password");
        }
    }
}
