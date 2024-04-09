package com.nadun.tm.controller;

import com.nadun.tm.dao.request.TeamCreationRequest;
import com.nadun.tm.entity.Team;
import com.nadun.tm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
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

    @PostMapping()
    public ResponseEntity<String> createTeam(@RequestBody TeamCreationRequest request){
            String name = request.getName();
            System.out.println(name);
            teamService.createTeam(name);
            return ResponseEntity.ok("Team Created");
    }

    @GetMapping("/all")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }


}

