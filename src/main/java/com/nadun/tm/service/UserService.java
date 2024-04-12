package com.nadun.tm.service;

import com.nadun.tm.entity.Team;
import com.nadun.tm.entity.User;
import com.nadun.tm.repository.ITeamRepository;
import com.nadun.tm.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final ITeamRepository teamRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByTeam(Long teamId) {
        return userRepository.findAllByTeamId(teamId);
    }

    public List<User> getUsersOfTeam(Long teamId , Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id: " + userId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));

        return userRepository.findAll();
    }

    public User assignTeamToUser(Long userId, Long teamId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        user.setTeam(team);
        return userRepository.save(user);
    }

    @Override
    public UserDetailsService userDetailsService() {
        System.out.println("User Details Service Running");
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

