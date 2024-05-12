package io.github.singhalmradul.followservice.services;

import static java.util.Collections.emptySet;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.singhalmradul.followservice.model.User;
import io.github.singhalmradul.followservice.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class UserFollowServiceImpl implements UserFollowService {

    private final UserRepository repository;

    @Override
    public Set<User> getFollowers(UUID userId) {
        return repository.findById(userId).map(User::getFollowers).orElse(emptySet());
    }

    @Override
    public Set<User> getFollowing(UUID userId) {
        return repository.findById(userId).map(User::getFollowing).orElse(emptySet());
    }

    @Override
    public void followUser(UUID userId, UUID followId) {

        User user = repository.findById(userId).orElse(new User(userId));
        User follow = repository.findById(followId).orElse(new User(followId));

        user.getFollowing().add(follow);
        follow.getFollowers().add(user);

        repository.save(user);
        repository.save(follow);
    }

    @Override
    public boolean isFollowing(UUID userId, UUID followId) {
        return repository.doesUserFollow(userId, followId);
    }

    @Override
    public void unfollowUser(UUID userId, UUID followId) {

        User user = repository.findById(userId).orElseThrow();
        User follow = repository.findById(followId).orElseThrow();

        follow.getFollowers().remove(user);
        user.getFollowing().remove(follow);

        repository.save(user);
        repository.save(follow);
    }
}
