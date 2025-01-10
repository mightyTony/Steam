package tony.project.steam.domain.profile.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    private Long id;
    private Long user_to; // user.id
    private Long user_from;
    private String content; // 댓글 내용
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public static Comment makeReply(Long user_to, Long user_from, String content) {
        Comment comment = new Comment();
        comment.user_to = user_to;
        comment.user_from = user_from;
        comment.content = content;
        comment.created_date = LocalDateTime.now();
        comment.modified_date = LocalDateTime.now();
        return comment;
    }
}
