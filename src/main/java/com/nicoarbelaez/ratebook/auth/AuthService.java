package com.nicoarbelaez.ratebook.auth;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicoarbelaez.ratebook.auth.dto.AuthRegisterDto;
import com.nicoarbelaez.ratebook.auth.dto.AuthTokenDto;
import com.nicoarbelaez.ratebook.jwt.JwtService;
import com.nicoarbelaez.ratebook.user.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final JwtService jwtService;

    @Transactional
    public Optional<AuthTokenDto> create(AuthRegisterDto authUser) {
        User user = User.builder()
            .firstName(authUser.getFirstName())
            .lastName(authUser.getLastName())
            .build();    
            
        Auth auth = Auth.builder()
            .email(authUser.getEmail())
            .password(authUser.getPassword())
            .user(user)
            .build();

        authRepository.save(auth);
        return Optional.of(AuthTokenDto.builder()
            .token(jwtService.getJwtToken(user))
            .build());
    }
}
