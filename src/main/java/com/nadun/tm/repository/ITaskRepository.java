package com.nadun.tm.repository;

import com.nadun.tm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "task",path = "task")
public interface ITaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.assignedTo.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Task t JOIN t.assignedTo u WHERE u.team.id = :teamId")
    List<Task> findTasksByTeamId(@Param("teamId") Long teamId);

}
