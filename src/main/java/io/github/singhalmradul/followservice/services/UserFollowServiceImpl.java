package io.github.singhalmradul.followservice.services;

import static java.util.Collections.emptyList;

import java.util.List;
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
    public List<User> getFollowers(UUID userId) {
        return repository.findById(userId).map(User::getFollowers).orElse(emptyList());
    }

    @Override
    public List<User> getFollowing(UUID userId) {
        return repository.findById(userId).map(User::getFollowing).orElse(emptyList());
    }

    @Override
    public void followUser(UUID userId, UUID followId) {
        User user = repository.findById(userId).orElse(new User(userId));
        User follow = repository.findById(followId).orElse(new User(followId));
        user.getFollowing().add(follow);
        repository.save(user);
    }

    @Override
    public boolean isFollowing(UUID userId, UUID followId) {
        return repository.doesUserFollow(userId, followId);
    }
}
