package tony.project.steam.domain.auth.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(description = "사용자 아이디", example = "user123")
    private String userId;
    @Schema(description = "비밀번호", example = "password123")
    private String password;
}
