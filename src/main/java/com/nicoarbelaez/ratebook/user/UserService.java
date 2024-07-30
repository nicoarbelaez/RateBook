package com.nicoarbelaez.ratebook.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicoarbelaez.ratebook.auth.Auth;
import com.nicoarbelaez.ratebook.auth.AuthRepository;
import com.nicoarbelaez.ratebook.user.dto.UserRegistrationDto;
import com.nicoarbelaez.ratebook.user.dto.mapper.UserMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<User> createUser(UserRegistrationDto dto, String email, String password) {
        if (authRepository.findByEmail(email).isPresent()) {
            return Optional.empty();
        }

        User savedUser = userRepository.save(UserMapper.toEntity(dto));

        Auth auth = new Auth();
        auth.setUser(savedUser);
        auth.setEmail(email);
        auth.setPassword(password);
        authRepository.save(auth);

        return Optional.of(savedUser);
    }

    @Transactional
    public Optional<User> updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        Optional<Auth> existingAuth = authRepository.findById(id);

        if (!existingUser.isPresent() && existingAuth.isPresent()) {
            return Optional.empty();
        }

        User userToUpdate = existingUser.get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setDate(user.getDate());
        return Optional.of(userRepository.save(userToUpdate));
    }

    @Transactional
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
