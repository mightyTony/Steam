package tony.project.steam.domain.profile.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.domain.auth.entity.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfile {

    private Long id;
    private Long user_code; // user.id
    private String username; // 닉네임
    private String content; // 할 말
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public static UserProfile createProfile(Long user_code, String username, String content) {
        UserProfile profile = new UserProfile();
        profile.user_code = user_code;
        profile.username = username;
        profile.content = content;
        profile.created_date = LocalDateTime.now();
        profile.modified_date = LocalDateTime.now();
        return profile;
    }
}
