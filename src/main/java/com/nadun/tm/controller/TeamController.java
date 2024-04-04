package com.nadun.tm.controller;

import com.nadun.tm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PutMapping("/{teamId}/leader/{userId}")
    public ResponseEntity<String> assignTeamLeader(@PathVariable Long teamId, @PathVariable Long userId) {
        teamService.assignTeamLeader(teamId, userId);
        return ResponseEntity.ok("Team leader assigned successfully.");
    }


}

