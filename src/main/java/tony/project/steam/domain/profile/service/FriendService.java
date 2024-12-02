package tony.project.steam.domain.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.repository.UserRepository;
import tony.project.steam.domain.auth.validator.AuthValidator;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.entity.dto.response.FriendResponse;
import tony.project.steam.domain.profile.repository.FriendRepository;
import tony.project.steam.domain.profile.validator.FriendValidator;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final FriendValidator friendValidator;
    private final AuthValidator userValidator;

    // 친구 요청
    @Transactional
    public void requestFriend(User user, String friendId) {
        // 친구 요청 대상 유저 유무 체크
        User friend = userValidator.isUserExistReturnUser(friendId);

        // 이미 친구 요청이 갔는 지 확인
        Friend request = friendRepository.findFriendByUserAndFriend(user, friend);
        if(request != null) {
            throw new CustomException(ErrorCode.ALREADY_REQUESTED);
        }

        // 친구 요청 로직
        Friend friendShip = Friend.builder()
                .user(user)
                .friend(friend)
                .status(FriendStatus.WAITING)
                .build();

        friendRepository.save(friendShip);
    }

    // 친구 요청들 조회
    public List<FriendResponse> getFriendRequests(User user) {
        List<FriendResponse> requests = friendRepository.findFriendRequests(user);
        return requests;
    }

    // 해당 친구 요청 삭제
    @Transactional
    public void deleteFriendRequest(Long id) {
        friendRepository.deleteById(id);
    }

    // 친구 요청 수락, 거절
}
