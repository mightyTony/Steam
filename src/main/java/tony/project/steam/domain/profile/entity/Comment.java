package tony.project.steam.domain.profile.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.domain.auth.entity.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    private Long id;
    private Long user_code; // user.id
    private String content; // 댓글 내용
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public static Comment makeReply(Long user_code, String content) {
        Comment comment = new Comment();
        comment.user_code = user_code;
        comment.content = content;
        comment.created_date = LocalDateTime.now();
        comment.modified_date = LocalDateTime.now();
        return comment;
    }
}
