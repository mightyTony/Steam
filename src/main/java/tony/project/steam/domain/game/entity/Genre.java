package tony.project.steam.domain.game.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Genre {
    private Long id;
    private Long game_code;
    private String genre_1;
    private String genre_2;
    private String genre_3;


    @Builder
    public Genre(Long game_code, String genre_1, String genre_2, String genre_3) {
        this.game_code = game_code;
        this.genre_1 = genre_1;
        this.genre_2 = genre_2;
        this.genre_3 = genre_3;
    }
}
