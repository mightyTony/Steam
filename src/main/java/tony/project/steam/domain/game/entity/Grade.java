package tony.project.steam.domain.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 게임 평점/평가 엔티티
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Grade {
    private Long id;
    private Long game_code;
    private Long user_code;
    private String content;
    private Boolean rate; // true: 추천, false: 비추천
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public static Grade createReply(Long game_code, Long user_code, String content, Boolean rate) {
        Grade grade = new Grade();
        grade.game_code = game_code;
        grade.user_code = user_code;
        grade.content = content;
        grade.rate = rate;
        grade.created_date = LocalDateTime.now();
        grade.modified_date = LocalDateTime.now();
        return grade;
    }
}
