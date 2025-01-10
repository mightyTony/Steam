package tony.project.steam.domain.profile.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.mapper.ProfileMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProfileValidator {

    private final ProfileMapper profileMapper;

    public void isAuthenticated(Long toUser, User user) {
        if(!profileMapper.isAuthenticated(toUser, user.getId())) {
            throw new CustomException(ErrorCode.ACCESS_DENIED);
        }
    }
}
