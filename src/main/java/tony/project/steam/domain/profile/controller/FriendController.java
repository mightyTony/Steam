package tony.project.steam.domain.profile.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.service.FriendService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/request")
    public ResponseEntity<ApiResponse<Void>> requestFriend(@RequestParam("friendId") String friendId, @AuthenticationPrincipal User user) {
        log.info("[FriendController - requestFriend] userId : {} , friendId: {}", user.getUserId(), friendId);
        friendService.requestFriend(user, friendId);
        return ResponseEntity.ok(ApiResponse.success(null, "친구 요청 완료"));
    }
}
