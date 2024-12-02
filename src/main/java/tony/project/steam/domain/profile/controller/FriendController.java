package tony.project.steam.domain.profile.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.dto.response.FriendResponse;
import tony.project.steam.domain.profile.service.FriendService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend")
public class FriendController {

    private final FriendService friendService;

    // 친구 요청
    @PostMapping("/request")
    public ResponseEntity<ApiResponse<Void>> requestFriend(@RequestParam("friendId") String friendId, @AuthenticationPrincipal User user) {
        log.info("[FriendController - requestFriend] userId : {} , friendId: {}", user.getUserId(), friendId);
        friendService.requestFriend(user, friendId);
        return ResponseEntity.ok(ApiResponse.success(null, "친구 요청 완료"));
    }

    // 친구 요청 목록 조회
    @GetMapping("/requests")
    public ResponseEntity<ApiResponse<List<FriendResponse>>> getPendingRequests(@AuthenticationPrincipal User user) {
        log.info("[FriendController - getPendingRequests] userId : {}", user.getUserId());
        List<FriendResponse> friendRequests = friendService.getFriendRequests(user);

        return ResponseEntity.ok(ApiResponse.success(friendRequests,"친구 요청 조회 완료"));
    }

    @DeleteMapping("/request/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteFriendRequest(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        log.info("[FriendController - deleteFriendRequest] id : {}", id);
        friendService.deleteFriendRequest(id);

        return ResponseEntity.ok(ApiResponse.success(null, "친구 요청 삭제 완료"));
    }
}
