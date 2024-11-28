package tony.project.steam.domain.profile.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.entity.QFriend;


@RequiredArgsConstructor
public class FriendRepositoryCustomImpl implements FriendRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    QFriend friend = QFriend.friend1;

    @Override
    public Friend findFriendByUserAndFriend(User user, User target) {
        return queryFactory
                .selectFrom(friend)
                .where(friend.user.eq(user)
                        .and(friend.friend.eq(target)))
                .fetchOne();
    }
}
