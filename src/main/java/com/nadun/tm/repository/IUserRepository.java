package com.nadun.tm.repository;

import com.nadun.tm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "user",path = "user")
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
