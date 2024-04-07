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

    private final UserFollowService userFollowService;

    @Override
    public ServerResponse getFollowers(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable("userId"));
        return ok().body(userFollowService.getFollowers(userId));
    }

    @Override
    public ServerResponse getFollowing(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable("userId"));
        return ok().body(userFollowService.getFollowing(userId));
    }
}
