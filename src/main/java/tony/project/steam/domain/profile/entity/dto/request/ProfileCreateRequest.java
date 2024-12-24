package tony.project.steam.domain.profile.entity.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class ProfileCreateRequest {
    private Long user_code;
    private String username;
    private String content;

    @Builder
    public ProfileCreateRequest(Long user_code, String username, String content) {
        this.user_code = user_code;
        this.username = username;
        this.content = content;
    }
}
