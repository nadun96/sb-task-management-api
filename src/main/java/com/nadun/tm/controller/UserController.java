package com.nadun.tm.controller;

import com.nadun.tm.entity.User;
import com.nadun.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{userId}/team/{teamId}")
    public ResponseEntity<String> assignTeamToUser(@PathVariable Long userId, @PathVariable Long teamId) {
        userService.assignTeamToUser(userId, teamId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Team Assigned");
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/team/{teamId}")
    public List<User> getUsersOfTeam(@PathVariable Long teamId) {
        return userService.getUsersByTeam(teamId);
    }
}
