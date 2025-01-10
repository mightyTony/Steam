package tony.project.steam.domain.profile.entity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MyGameResponse {
    private Long id;
    private Long user_code;
    private Long game_code;

    // game
    private String name;
    private String picture;

    @Builder
    public MyGameResponse(Long user_code, Long game_code, String name, String picture) {
        this.user_code = user_code;
        this.game_code = game_code;
        this.name = name;
        this.picture = picture;
    }
}
