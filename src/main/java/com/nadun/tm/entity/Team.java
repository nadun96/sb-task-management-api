package com.nadun.tm.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(optional = true)
    @JsonIgnore
    @JoinColumn(name = "leader_id", referencedColumnName = "id")
    private User leader;


    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<User> members;

    @Override
    public String toString(){
        return id.toString();
    }
}
