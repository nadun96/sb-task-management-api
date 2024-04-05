package com.nadun.tm.controller;

import com.nadun.tm.entity.User;
import com.nadun.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{userId}/team/{teamId}")
    public ResponseEntity<User> assignTeamToUser(@PathVariable Long userId, @PathVariable Long teamId) {
        User updatedUser = userService.assignTeamToUser(userId, teamId);
        return ResponseEntity.ok(updatedUser);
    }
}
