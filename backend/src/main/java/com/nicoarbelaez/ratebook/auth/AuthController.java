package com.nicoarbelaez.ratebook.auth;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoarbelaez.ratebook.auth.dto.AuthRegisterDto;
import com.nicoarbelaez.ratebook.auth.dto.AuthTokenDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Optional<AuthTokenDto>> register(@RequestBody AuthRegisterDto dto) {
        return ResponseEntity.ok(authService.create(dto));
    }

    // @PostMapping("/login")
    // public ResponseEntity<Optional<AuthTokenDto>> login(@RequestBody AuthRegisterDto dto) {
    //     return ResponseEntity.ok(authService.login(dto));
    // }
}
