package io.github.singhalmradul.followservice.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

import java.util.HashSet;
import java.util.Set;
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
    private Set<User> following = new HashSet<>();

    @JsonIgnore
    @Relationship(type = "FOLLOWS", direction = INCOMING)
    private Set<User> followers = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof User user)
            return id.equals(user.id);
        return false;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
