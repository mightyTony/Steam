package tony.project.steam.domain.profile.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.entity.dto.response.FriendshipResponse;
import tony.project.steam.domain.profile.service.FriendShipService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile/friendship")
@Tag(name = "친구 관련 API", description = "친구 관련 API")
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
public class FriendShipController {

    private final FriendShipService friendShipService;

    // 친구 요청
    @Operation(summary = "친구 요청")
    @PostMapping("/request")
    public ResponseEntity<ApiResponse<Void>> friendshipRequest(@AuthenticationPrincipal User user, String friendId) {
        friendShipService.requestFriend(user, friendId);
        return ResponseEntity.ok(ApiResponse.success(null,"친구 요청 성공"));
    }


    // 친구 요청들 조회
    @Operation(summary = "친구 요청들 조회")
    @GetMapping("/requests")
    public ResponseEntity<ApiResponse<List<FriendshipResponse>>> getFriendShipRequests(@AuthenticationPrincipal User user) {
        List<FriendshipResponse> requests = friendShipService.getFriendRequests(user);

        return ResponseEntity.ok(ApiResponse.success(requests, "친구 요청 조회 성공"));
    }

    // 친구 요청 거절 및 삭제
    @Operation(summary = "친구 요청 수락/거절")
    @PatchMapping("/request/{requestId}")
    public ResponseEntity<ApiResponse<Void>> requestApplyOrDeny(@AuthenticationPrincipal User user,
                                                                Long requestId,
                                                                String requesterId,
                                                                FriendStatus status) {
        friendShipService.requestApplyOrDeny(requestId, requesterId, status);

        return ResponseEntity.ok(ApiResponse.success(null,"반영 되었습니다."));
    }

    @DeleteMapping("/{friendshipId}")
    public ResponseEntity<ApiResponse<Void>> deleteFriendship(@PathVariable Long friendshipId) {
        friendShipService.deleteFriendRequest(friendshipId);

        return ResponseEntity.ok(ApiResponse.success());
    }


}
