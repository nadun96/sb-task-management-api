package com.nadun.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.MEMBER;

    @PrePersist
    public void setDefaultRole() {
        if (this.role == null) {
            this.role = Role.MEMBER;
        }
    }

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "team_id", referencedColumnName = "id",nullable = true)
    private Team team;

}
