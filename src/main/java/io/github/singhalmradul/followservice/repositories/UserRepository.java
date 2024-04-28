package io.github.singhalmradul.followservice.repositories;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import io.github.singhalmradul.followservice.model.User;

public interface UserRepository extends Neo4jRepository<User, UUID> {

    @Query("""
        MATCH (u:User {id: $userId})-[:FOLLOWS]->(f:User {id: $followId})
        RETURN COUNT(f) > 0
    """)
    boolean doesUserFollow(@Param("userId") UUID userId, @Param("followId") UUID followId);
}