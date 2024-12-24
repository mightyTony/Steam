package tony.project.steam.domain.profile.entity.dto.response;

import lombok.Data;

@Data
public class ProfileResponse {
    private Long id;
    private String nickname;
    private String content;
    private Long userCode;
    private String profilePicture;
}
