package tony.project.steam.domain.game.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "genre")
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_code")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_code")
    private Game game;

    @Column(name = "genre_1")
    private String genre_1;

    @Column(name = "genre_2")
    private String genre_2;

    @Column(name = "genre_3")
    private String genre_3;
}
