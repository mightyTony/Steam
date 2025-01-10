package tony.project.steam.domain.profile.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.entity.Comment;
import tony.project.steam.domain.profile.entity.dto.request.CreateCommentRequest;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.MyGameResponse;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;
import tony.project.steam.domain.profile.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
@Slf4j
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @Operation(summary = "프로필 정보 수정")
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ProfileResponse>> updateMyProfile(@PathVariable("id") Long userCode,
                                                                       @RequestBody ProfileUpdateRequest request) {
        ProfileResponse response = profileService.updateMyProfile(userCode, request);

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 마이 게임
    @Operation(summary = "내 게임 목록 출력")
    @GetMapping("/{id}/games")
    public ResponseEntity<ApiResponse<List<MyGameResponse>>> getMyGames(@PathVariable("id") Long userCode) {

        List<MyGameResponse> games = profileService.getMyGames(userCode);

        return ResponseEntity.ok(ApiResponse.success(games));
    }

    // 댓글 등록
    @Operation(summary = "댓글 등록")
    @PostMapping("/{id}/comment/post")
    public ResponseEntity<ApiResponse<Comment>> postComment(@PathVariable("id") Long toUser,
                                                            @RequestBody CreateCommentRequest request) {
        profileService.postComment(toUser, request);

        return ResponseEntity.ok(ApiResponse.success());
    }

    // 댓글 수정

    // 댓글 삭제(권한 체크)
    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{user}/comment/{id}")
    public ResponseEntity<ApiResponse<Comment>> deleteComment(@PathVariable("user") Long toUser,
                                                              @PathVariable("id") Long commentId,
                                                              @AuthenticationPrincipal User user) {
        profileService.deleteComment(toUser, commentId, user);

        return ResponseEntity.ok(ApiResponse.success());
    }
}
