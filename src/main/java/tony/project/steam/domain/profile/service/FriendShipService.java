package tony.project.steam.domain.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.profile.entity.dto.response.FriendshipResponse;
import tony.project.steam.domain.profile.mapper.FriendShipMapper;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.validator.AuthValidator;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.entity.Friendship;

import tony.project.steam.domain.profile.validator.FriendShipValidator;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendShipService {

    private final FriendShipValidator friendShipValidator;
    private final AuthValidator userValidator;
    private final FriendShipMapper friendShipMapper;

    // 친구 요청
    @Transactional
    public void requestFriend(User user, String friendId) {
        // 친구 요청 대상 유저 유무 체크
        User friend = userValidator.isUserExistReturnUser(friendId);

        // 이미 친구 요청이 갔는 지 확인
        Friendship request = friendShipMapper.findFriendByUserAndFriend(user, friend);
        if(request != null) {
            throw new CustomException(ErrorCode.ALREADY_REQUESTED);
        }

        // 친구 요청 로직
        Friendship friendShip = Friendship.builder()
                .user_id(user.getId())
                .friend_id(friend.getId())
                .status(FriendStatus.WAITING)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        friendShipMapper.save(friendShip);

        log.info("[친구 요청] user: {}, friend: {}", user.getUserId(), friend.getUserId());
    }

    // 친구 요청들 조회
    public List<FriendshipResponse> getFriendRequests(User user) {
        List<FriendshipResponse> requests = friendShipMapper.findFriendRequests();
        return requests;
    }

    @Transactional
    public void requestApplyOrDeny(Long friendshipRequestId, String requesterNickname, FriendStatus status) {
        // 1. 요청자 조회
        userValidator.isUserExistByNickname(requesterNickname);
        log.info("[requestApplyOrDeny] - status = {}, nickname = {}", status,requesterNickname );
        // 2. 관계 조회
        friendShipValidator.isExistRequest(friendshipRequestId);
        // 3. 업데이트
        friendShipMapper.updateFriendshipStatus(friendshipRequestId, status);
    }

    // 해당 친구 요청 삭제
    @Transactional
    public void deleteFriendRequest(Long id) {
        friendShipMapper.deleteById(id);
    }

}
