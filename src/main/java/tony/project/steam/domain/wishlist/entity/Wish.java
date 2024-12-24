package tony.project.steam.domain.wishlist.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Wish {

    private Long id;
    private Long userCode;
    private Long gameCode;

    @Builder
    public Wish(Long userCode, Long gameCode) {
        this.userCode = userCode;
        this.gameCode = gameCode;
    }
}
