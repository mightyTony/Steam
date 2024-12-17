package tony.project.steam.domain.order.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Cart {
    private Long id;
    private Long user_code;
    private Long game_code;
}
