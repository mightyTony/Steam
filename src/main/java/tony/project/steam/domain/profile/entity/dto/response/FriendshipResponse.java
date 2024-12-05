package tony.project.steam.domain.profile.entity.dto.response;

import lombok.Data;

@Data
public class FriendshipResponse {
    private Long id;
    private String nickname;
    private String profile_picture;
}
