package io.github.singhalmradul.followservice.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

import java.util.List;
import java.util.UUID;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.GeneratedValue.UUIDGenerator;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Data
@Node
public class User {

    @Id
    @GeneratedValue(UUIDGenerator.class)
    private UUID id;

    @Relationship(type = "FOLLOW", direction = OUTGOING)
    private List<User> following;

    @Relationship(type = "FOLLOW", direction = INCOMING)
    private List<User> followers;
}
