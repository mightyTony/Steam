package tony.project.steam.domain.auth.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.entity.dto.request.JoinRequest;
import tony.project.steam.domain.auth.mapper.AuthMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthValidator {
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    public void validate(JoinRequest request) {
        if(authMapper.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }
        if(authMapper.existsByUserId(request.getUserId())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
    }

    // 아이디, 비번 체크
    public void authCheck(String userId, String rawPassword) {
        User user = authMapper.findByUserId(userId)
                .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
        log.info("[AuthValidator] authCheck - 비번: {}", rawPassword, user.getPassword());
        if(!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new CustomException(ErrorCode.AUTHENTICATION_FAILED);
        }
    }

    // 본인 인지 확인
    public void isYou(String userId) {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = authentication.getName(); // 예: `userId`를 `username`으로 저장했을 경우

        log.info("[AuthValidator] isYou - 현재 유저 아이디: {}, 파라미터 아이디 : {}", currentUserId, userId);
        if(!currentUserId.equals(userId)) {
            throw new CustomException(ErrorCode.ACCESS_DENIED);
        }
    }

    // 유저 정보 중복 체크
    public void isDuplicateInformation(String email, String phoneNumber) {
        if(authMapper.existsByEmail(email)) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        if(authMapper.existsByPhoneNumber(phoneNumber)) {
            throw new CustomException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }
    }

    // 유저 존재 체크
    public void isUserExist(String userId) {
        if(!authMapper.existsByUserId(userId)) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
    }

    // 유저 존재 체크, 유저 반환
    public User isUserExistReturnUser(String userId) {
        return authMapper.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    public void isUserExistByNickname(String nickname) {
        if(!authMapper.existsByNickname(nickname)){
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

    }

    public User isUserExistReturnUser(Long userCode) {
        return authMapper.findByUserCode(userCode)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
