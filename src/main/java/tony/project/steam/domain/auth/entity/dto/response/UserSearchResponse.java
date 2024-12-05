package tony.project.steam.domain.auth.entity.dto.response;

import lombok.Data;

@Data
public class UserSearchResponse {
    private String userId;
    private String username;
    private String profilePicture;
}
