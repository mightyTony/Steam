package tony.project.steam.domain.wishlist.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WishRequest {
    @Schema(description = "유저 코드", example = "1")
    private Long userCode;
    @Schema(description = "게임 코드", example = "22")
    private Long gameCode;
}
