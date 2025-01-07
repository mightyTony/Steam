package tony.project.steam.domain.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.entity.dto.request.UserUpdateRequest;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;
import tony.project.steam.domain.auth.entity.dto.response.UserUpdateResponse;
import tony.project.steam.domain.auth.mapper.UserMapper;
import tony.project.steam.domain.auth.validator.AuthValidator;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final AuthValidator authValidator;

    public Page<UserSearchResponse> searchUsersPaging(String keyword, int page, int size) {
        int offset = (page - 1) * size;

        // 데이터 조회
        List<UserSearchResponse> users = userMapper.searchUsersPaging(keyword, offset, size);
        // 전체 해당 유저 수
        int totalInUsers = userMapper.countSearchedUsers(keyword);

        // 객체
        Pageable pageable = PageRequest.of(page -1 , size);

        // Page 객체
        return new PageImpl<>(users, pageable, totalInUsers);
    }

    @Transactional(readOnly = true)
    public List<UserSearchResponse> getRandomUserLists() {

        return userMapper.getRandomUsers();
    }

    @Transactional
    public UserUpdateResponse updateUserInfo(UserUpdateRequest request) {
        // 1. 조회
        authValidator.isYou(request.getUserId());



        User updatedInfo = User.builder()
                .id(request.getId())
//                .username(request.getUsername())
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .profilePicture(request.getProfilePicture())
                .build();
                // 업데이트
        int updatedRows = userMapper.updateUserInfo(updatedInfo);

        if(updatedRows == 0) {
            throw new CustomException(ErrorCode.USER_INFO_UPDATE_FAILED);
        }

        // 응답
        UserUpdateResponse response = UserUpdateResponse.builder()
                .username(updatedInfo.getUsername())
                .name(updatedInfo.getName())
                .email(updatedInfo.getEmail())
                .phoneNumber(updatedInfo.getPhoneNumber())
                .profilePicture(updatedInfo.getProfilePicture())
                .build();

        return response;
    }
}
