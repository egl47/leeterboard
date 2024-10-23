package com.example.leeterboard.controller;

import com.example.leeterboard.model.*;
import com.example.leeterboard.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/leaderboards")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom(@RequestParam String roomId) {
        Room room = leaderboardService.createRoom(roomId);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/{roomId}/users")
    public ResponseEntity<List<User>> getUsersForRoom(@PathVariable String roomId) {
        List<User> users = leaderboardService.getUsersForRoom(roomId);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{roomId}/addUser")
    public ResponseEntity<User> addUserToRoom(@PathVariable String roomId, @RequestParam String username) {
        User user = leaderboardService.addUserToRoom(roomId, username);
        return ResponseEntity.ok(user);
    }
}
