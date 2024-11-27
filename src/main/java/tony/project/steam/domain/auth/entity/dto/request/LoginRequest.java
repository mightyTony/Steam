package tony.project.steam.domain.auth.entity.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}
