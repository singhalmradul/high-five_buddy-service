package io.github.singhalmradul.followservice.repositories;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import io.github.singhalmradul.followservice.model.User;

public interface UserRepository extends Neo4jRepository<User, UUID> {}