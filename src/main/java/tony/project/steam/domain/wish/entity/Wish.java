package tony.project.steam.domain.wish.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.game.entity.Game;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "wish")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_code")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_code", nullable = false)
    private Game game;

    public static Wish createWish(User user, Game game) {
        Wish wish = new Wish();
        wish.user = user;
        wish.game = game;

        return wish;
    }
}
