package io.github.singhalmradul.followservice.handlers;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public interface UserFollowHandler {

    ServerResponse getFollowers(ServerRequest request);

    ServerResponse getFollowing(ServerRequest request);

}