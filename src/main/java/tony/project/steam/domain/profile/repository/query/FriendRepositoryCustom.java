package tony.project.steam.domain.profile.repository.query;

import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Friend;

public interface FriendRepositoryCustom {
    Friend findFriendByUserAndFriend(User user, User friend);
}
