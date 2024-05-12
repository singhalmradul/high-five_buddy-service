package io.github.singhalmradul.followservice.services;

import java.util.Set;
import java.util.UUID;

import io.github.singhalmradul.followservice.model.User;

public interface UserFollowService {

    Set<User> getFollowers(UUID userId);

    Set<User> getFollowing(UUID userId);

    void followUser(UUID userId, UUID followId);

    void unfollowUser(UUID userId, UUID followId);

    boolean isFollowing(UUID userId, UUID followId);
}