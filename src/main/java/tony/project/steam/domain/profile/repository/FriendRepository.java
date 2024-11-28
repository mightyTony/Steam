package tony.project.steam.domain.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.repository.query.FriendRepositoryCustom;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> , FriendRepositoryCustom {
//    Friend findByUserAndFriend(User user, User friend);
}
