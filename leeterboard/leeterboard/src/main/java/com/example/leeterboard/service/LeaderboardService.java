package com.example.leeterboard.service;

import com.example.leeterboard.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.leeterboard.repository.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LeaderboardService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public Room createRoom(String roomId) {
        Room room = new Room(roomId);
        return roomRepository.save(room);
    }

    public List<User> getUsersForRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return new ArrayList<>(room.getUsers());
    }

    public User addUserToRoom(String roomId, String username) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    
        // Check if user already exists in the room to avoid duplicates (Optional, based on your business logic)
        Optional<User> existingUser = userRepository.findByUsername(username);
        User user;
    
        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            // Create a new user if not already present
            user = new User();
            user.setUsername(username);
            user.setProblemsSolved(0); // You can later fetch from LeetCode API
            user.setEasyProblemsSolved(0);
            user.setMediumProblemsSolved(0);
            user.setHardProblemsSolved(0);
    
            // Save the user first, if they're new
            user = userRepository.save(user);
        }
    
        // Add the user to the room's set of users
        room.getUsers().add(user);
    
        // Save the room to persist the relationship
        roomRepository.save(room);
    
        return user;
    }
}