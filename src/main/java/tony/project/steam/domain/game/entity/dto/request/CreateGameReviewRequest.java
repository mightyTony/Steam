package tony.project.steam.domain.game.entity.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateGameReviewRequest {
    // grade
    private Long game_code;
    //private Long user_code;
    private String content;
    private Boolean rate;
}
