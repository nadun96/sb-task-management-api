package com.nadun.tm.service;

import com.nadun.tm.entity.Role;
import com.nadun.tm.entity.Team;
import com.nadun.tm.entity.User;
import com.nadun.tm.repository.IUserRepository;
import com.nadun.tm.repository.ITeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final ITeamRepository teamRepository;
    private final IUserRepository userRepository;

    @Autowired
    public TeamService(ITeamRepository teamRepository, IUserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }


    public void assignTeamLeader(Long teamId, Long userId) {
        Team newTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + teamId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        // Remove the user from the current team's leader role
        Team currentTeam = user.getTeam();

        if (currentTeam != null) {
            currentTeam.setLeader(null);
            teamRepository.save(currentTeam);
        }

        newTeam.setLeader(user);
        teamRepository.save(newTeam);

        user.setRole(Role.LEADER);
        user.setTeam(newTeam);
        userRepository.save(user);
    }

    public void createTeam(String name){
        Team team = new Team();
        team.setName(name);
        teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}

