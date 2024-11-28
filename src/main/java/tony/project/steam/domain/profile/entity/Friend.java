package tony.project.steam.domain.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.domain.auth.entity.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friend {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_code")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User friend;

    @Enumerated(EnumType.STRING)
    private FriendStatus status;

    @Builder
    public Friend(User user, User friend, FriendStatus status) {
        this.user = user;
        this.friend = friend;
        this.status = status;
    }

}
