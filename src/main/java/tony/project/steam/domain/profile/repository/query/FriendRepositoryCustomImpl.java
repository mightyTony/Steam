package tony.project.steam.domain.profile.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tony.project.steam.domain.auth.entity.QUser;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.entity.QFriend;
import tony.project.steam.domain.profile.entity.dto.response.FriendResponse;
import tony.project.steam.domain.profile.entity.dto.response.QFriendResponse;

import java.util.List;


@RequiredArgsConstructor
public class FriendRepositoryCustomImpl implements FriendRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Friend findFriendByUserAndFriend(User user, User target) {
        QFriend friend = QFriend.friend1;

        return queryFactory
                .selectFrom(friend)
                .where(friend.user.eq(user)
                        .and(friend.friend.eq(target)))
                .fetchOne();
    }

    @Override
    public List<FriendResponse> findFriendRequests(User user) {
        QFriend friend = QFriend.friend1;
        QUser requester = QUser.user;
        return queryFactory
                .select(
                        new QFriendResponse(
                                requester.username,
                                requester.profilePicture
                        )
                )
                .from(friend)
                .join(friend.user, requester)
                .where(
                        friend.user.id.eq(user.getId())
                                .and(friend.status.eq(FriendStatus.WAITING))
                )
                .fetch();
    }
}
