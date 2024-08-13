package com.nicoarbelaez.ratebook.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
        Optional<Auth> findByEmail(String email);
}
