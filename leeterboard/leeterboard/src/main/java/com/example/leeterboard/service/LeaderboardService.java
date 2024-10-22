package com.example.leeterboard.service;

import com.example.leeterboard.model.*;

@Service
public class LeaderboardService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public Room createRoom(String roomId) {
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    public List<User> getUsersForRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return userRepository.findByRoom(room);
    }

    public User addUserToRoom(String roomId, String username) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        User user = new User();
        user.setUsername(username);
        user.setRoom(room);
        user.setProblemsSolved(0); // Set initial value, could be fetched from LeetCode API later
        return userRepository.save(user);
    }
}
