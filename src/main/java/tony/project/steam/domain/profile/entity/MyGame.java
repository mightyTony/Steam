package tony.project.steam.domain.profile.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyGame {
    private Long id;
    private Long user_code; // user.id
    private Long game_code; // game.id
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public static MyGame intoMyGame(Long user_code, Long game_code) {
        MyGame myGame = new MyGame();
        myGame.user_code = user_code;
        myGame.game_code = game_code;
        myGame.created_date = LocalDateTime.now();
        myGame.modified_date = LocalDateTime.now();
        return myGame;
    }
}
