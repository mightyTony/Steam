package tony.project.steam.domain.profile.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.entity.Friendship;
import tony.project.steam.domain.profile.entity.dto.response.FriendshipResponse;

import java.util.List;

@Mapper
public interface FriendShipMapper {
    Friendship findFriendByUserAndFriend(User user, User friend);

    void save(Friendship friendShip);

    List<FriendshipResponse> findFriendRequests();

    void updateFriendshipStatus(@Param("friendshipRequestId") Long friendshipRequestId,
                                @Param("status") FriendStatus status);

    boolean findFriendRequest(Long friendshipRequestId);

    void deleteById(Long id);
}
