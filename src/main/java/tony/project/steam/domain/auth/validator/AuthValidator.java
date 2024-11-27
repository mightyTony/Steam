package tony.project.steam.domain.auth.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.entity.dto.request.JoinRequest;
import tony.project.steam.domain.auth.repository.UserRepository;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@RequiredArgsConstructor
public class AuthValidator {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void validate(JoinRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }
        if(userRepository.existsByUserId(request.getUserId())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
    }

    // 아이디, 비번 체크
    public void authCheck(String userId, String rawPassword) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));

        if(!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new CustomException(ErrorCode.AUTHENTICATION_FAILED);
        }
    }
}
