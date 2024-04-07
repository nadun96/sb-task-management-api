package com.nadun.tm.service;

import com.nadun.tm.entity.Team;
import com.nadun.tm.entity.User;
import com.nadun.tm.repository.ITeamRepository;
import com.nadun.tm.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final ITeamRepository ITeamRepository;

    public User assignTeamToUser(Long userId, Long teamId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Team team = ITeamRepository.findById(teamId)
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

