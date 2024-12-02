package tony.project.steam.domain.profile.repository.query;

import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.entity.dto.response.FriendResponse;

import java.util.List;

public interface FriendRepositoryCustom {
    Friend findFriendByUserAndFriend(User user, User friend);

    List<FriendResponse> findFriendRequests(User user);
}
