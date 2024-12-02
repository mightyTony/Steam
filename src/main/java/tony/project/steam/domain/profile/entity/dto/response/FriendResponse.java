package tony.project.steam.domain.profile.entity.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class FriendResponse {
    private String username;
    private String profilePicture;

    @QueryProjection
    public FriendResponse(String username, String profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }
}
