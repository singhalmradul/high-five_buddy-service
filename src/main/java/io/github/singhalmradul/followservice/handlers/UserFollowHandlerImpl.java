package io.github.singhalmradul.followservice.handlers;

import static org.springframework.web.servlet.function.ServerResponse.ok;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.followservice.services.UserFollowService;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Component
public class UserFollowHandlerImpl implements UserFollowHandler {

    private static final String USER_ID = "userId";
    private final UserFollowService userFollowService;

    @Override
    public ServerResponse getFollowers(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        return ok().body(userFollowService.getFollowers(userId));
    }

    @Override
    public ServerResponse getFollowing(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        return ok().body(userFollowService.getFollowing(userId));
    }

    @Override
    public ServerResponse followUser(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        UUID followId = UUID.fromString(request.pathVariable("followId"));
        userFollowService.followUser(userId, followId);
        return ok().build();
    }
}
