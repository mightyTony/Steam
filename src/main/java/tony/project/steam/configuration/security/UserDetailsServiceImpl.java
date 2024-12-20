package tony.project.steam.configuration.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tony.project.steam.domain.auth.mapper.AuthMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthMapper authMapper;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("[loadUserByUsername] userId: {}", userId);
        return authMapper.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
