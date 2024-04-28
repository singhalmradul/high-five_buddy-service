package io.github.singhalmradul.followservice.services;

import java.util.List;
import java.util.UUID;

import io.github.singhalmradul.followservice.model.User;

public interface UserFollowService {

    List<User> getFollowers(UUID userId);

    List<User> getFollowing(UUID userId);

    void followUser(UUID userId, UUID followId);

    boolean isFollowing(UUID userId, UUID followId);
}