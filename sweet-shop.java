package com.example.sweetshop.service;

import com.example.sweetshop.dto.AuthResponse;
import com.example.sweetshop.dto.RegisterRequest;
import com.example.sweetshop.entity.Role;
import com.example.sweetshop.entity.User;
import com.example.sweetshop.repository.UserRepository;
import com.example.sweetshop.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldRegisterUserSuccessfully() {
        // GIVEN
        RegisterRequest request = new RegisterRequest();
        request.setEmail("test@gmail.com");
        request.setPassword("password");
        request.setRole(Role.USER);

        when(userRepository.existsByEmail(request.getEmail()))
                .thenReturn(false);

        when(passwordEncoder.encode(any()))
                .thenReturn("encoded-password");

        when(jwtTokenProvider.generateToken(any()))
                .thenReturn("mock-jwt-token");

        // WHEN
        AuthResponse response = authService.register(request);

        // THEN
        assertNotNull(response);
        assertEquals("test@gmail.com", response.getEmail());
        assertEquals("mock-jwt-token", response.getToken());

        verify(userRepository, times(1))
                .save(any(User.class));
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        // GIVEN
        RegisterRequest request = new RegisterRequest();
        request.setEmail("test@gmail.com");

        when(userRepository.existsByEmail(request.getEmail()))
                .thenReturn(true);

        // THEN
        assertThrows(
                IllegalArgumentException.class,
                () -> authService.register(request)
        );

        verify(userRepository, never()).save(any());
    }
}
