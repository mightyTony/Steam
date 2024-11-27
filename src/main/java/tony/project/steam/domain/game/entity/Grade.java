package tony.project.steam.domain.game.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.common.BaseTimeEntity;
import tony.project.steam.domain.auth.entity.User;

// 게임 평점/평가 엔티티
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "grade")
public class Grade extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_code")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_code")
    private Game game;

    @Column(name = "grade_content", nullable = false)
    @Lob
    private String content;

    @Column(name = "grade_rate")
    private Boolean rate; // true: 추천, false: 비추천
}
