package com.nicoarbelaez.ratebook.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nicoarbelaez.ratebook.user.User;

@SpringBootTest
public class AuthRepositoryTest {

    @Autowired
    private AuthRepository authRepository;

    @Test
    public void saveAuth() {
        User user = User.builder()
                .firstName("Nicolas")
                .lastName("Arbelaez")
                .profileImageUrl("https://www.google.com")
                .build();

        Auth auth = Auth.builder()
                .email("asd@usc.edu.co")
                .password("123")
                .user(user)
                .build();

        authRepository.save(auth);
    }
}
