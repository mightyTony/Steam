package tony.project.steam.domain.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.mapper.UserMapper;
import tony.project.steam.domain.auth.service.UserService;
import tony.project.steam.domain.auth.validator.AuthValidator;
import tony.project.steam.domain.profile.entity.UserProfile;
import tony.project.steam.domain.profile.entity.dto.request.ProfileCreateRequest;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;
import tony.project.steam.domain.profile.mapper.ProfileMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileMapper profileMapper;
    private final UserService userService;
    private final AuthValidator authValidator;
    private final UserMapper userMapper;

    @Transactional
    public ProfileResponse updateMyProfile(Long userCode, ProfileUpdateRequest request) {
        // 1. 유저 조회
        User user = authValidator.isUserExistReturnUser(userCode);
        // 2. 프로필 업데이트
        profileMapper.updateMyProfile(request);
        // 3. 업데이트된 프로필 정보 조회, 반환
        ProfileResponse response = profileMapper.getProfileByUserCode(userCode);

        return response;
    }

    @Transactional
    public void makeProfile(ProfileCreateRequest request) {
        //
        UserProfile profile = UserProfile.createProfile(request.getUser_code(), request.getUsername(), request.getContent());

        profileMapper.saveProfile(profile);
    }
}
