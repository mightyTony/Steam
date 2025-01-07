package tony.project.steam.domain.auth.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Getter
@NoArgsConstructor
public class User implements UserDetails {
    private Long id;
    private String userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String profilePicture;
    private Role role;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return this.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Builder
    public User(Long id,String userId, String username, String password, String name, String email, String phoneNumber, String profilePicture) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
        this.role = Role.ROLE_USER;
    }

    public static User update(Long id,String username, String name, String email, String phoneNumber, String profilePicture ) {
        User user = new User();
        user.id = id;
        user.username = username;
        user.name = name;
        user.email = email;
        user.phoneNumber = phoneNumber;
        user.profilePicture = profilePicture;

        return user;
    }

}
