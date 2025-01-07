package tony.project.steam.domain.auth.entity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserUpdateResponse {
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private String profilePicture;

    @Builder
    public UserUpdateResponse(String username, String name, String email, String phoneNumber, String profilePicture) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
    }
}
