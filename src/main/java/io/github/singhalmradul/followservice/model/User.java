package io.github.singhalmradul.followservice.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.GeneratedValue.UUIDGenerator;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Node
public class User {

    @Id
    @NonNull
    @GeneratedValue(UUIDGenerator.class)
    private UUID id;

    @JsonIgnore
    @Relationship(type = "FOLLOWS", direction = OUTGOING)
    private List<User> following = new ArrayList<>();

    @JsonIgnore
    @Relationship(type = "FOLLOWS", direction = INCOMING)
    private List<User> followers = new ArrayList<>();
}
