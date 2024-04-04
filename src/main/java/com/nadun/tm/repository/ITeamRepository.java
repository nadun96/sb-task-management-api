package com.nadun.tm.repository;

import com.nadun.tm.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "team",path = "team")
public interface ITeamRepository extends JpaRepository<Team, Long> {
}
