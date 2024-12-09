package tony.project.steam.domain.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;
import tony.project.steam.domain.auth.mapper.UserMapper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

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

    public List<UserSearchResponse> getRandomUserLists() {

        return userMapper.getRandomUsers();
    }
}
