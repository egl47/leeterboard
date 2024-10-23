package com.example.leeterboard.repository;

import org.springframework.data.jpa.repository.*;
import com.example.leeterboard.model.*;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
