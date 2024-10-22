package com.example.leeterboard.controller;

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
