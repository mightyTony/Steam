package tony.project.steam.domain.profile.entity.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class ProfileUpdateRequest {
    // profile
//    private Long id;
    private Long user_code;
    private String content;

    @Builder
    public ProfileUpdateRequest(Long user_code,String content) {
        this.user_code = user_code;
        this.content = content;
    }
}
