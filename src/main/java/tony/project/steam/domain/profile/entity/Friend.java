package tony.project.steam.domain.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
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
    @JoinColumn(name = "user_code")
    private User user;

    @Column(name = "from_user", nullable = false)
    private String userId;

    @Column(name = "to_user", nullable = false)
    private String friendId;

    @Enumerated(EnumType.STRING)
    private FriendStatus status;


}
