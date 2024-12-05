package tony.project.steam.domain.profile.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friendship {
    private Long id;
    private Long user_id;
    private Long friend_id;
    private FriendStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public Friendship(Long user_id, Long friend_id, FriendStatus status, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
