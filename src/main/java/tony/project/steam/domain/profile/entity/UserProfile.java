package tony.project.steam.domain.profile.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.domain.auth.entity.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "profile")
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_code")
    private Long id;

    private String nickname; // 닉네임

    private String content; // 할 말

    @OneToOne(mappedBy = "userProfile")
    private User user;

}
