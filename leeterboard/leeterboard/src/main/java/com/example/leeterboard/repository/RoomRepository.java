package com.example.leeterboard.repository;

import org.springframework.data.jpa.repository.*;
import java.util.Optional;
import com.example.leeterboard.model.*;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomId(String roomId);
}