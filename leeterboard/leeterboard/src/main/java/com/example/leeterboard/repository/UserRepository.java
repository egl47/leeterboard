package com.example.leeterboard.repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;
import com.example.leeterboard.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoom(Room room);
}
