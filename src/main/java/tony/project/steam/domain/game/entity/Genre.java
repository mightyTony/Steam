package tony.project.steam.domain.game.entity;

import lombok.AccessLevel;
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

    public static Genre createGenre(Long game_code, String genre_1, String genre_2, String genre_3) {
        Genre genre = new Genre();
        genre.game_code = game_code;
        genre.genre_1 = genre_1;
        genre.genre_2 = genre_2;
        genre.genre_3 = genre_3;
        return genre;
    }
}
