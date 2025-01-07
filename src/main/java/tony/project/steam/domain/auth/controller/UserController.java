package tony.project.steam.domain.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.dto.request.UserUpdateRequest;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;
import tony.project.steam.domain.auth.entity.dto.response.UserUpdateResponse;
import tony.project.steam.domain.auth.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "User API", description = "유저 관련 API")
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    // 유저 검색 (아이디 or 닉네임)
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<UserSearchResponse>>> searchUsers(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<UserSearchResponse> result = userService.searchUsersPaging(keyword, page, size);

        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/random")
    public ResponseEntity<ApiResponse<List<UserSearchResponse>>> getRandomUserList() {
        List<UserSearchResponse> result = userService.getRandomUserLists();
        return ResponseEntity.ok(ApiResponse.success(result));
    }

    // 유저 정보 수정
    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserUpdateResponse>> updateUserInfo(@PathVariable("id") Long userCode, @RequestBody @Valid UserUpdateRequest request) {
        log.info("[Patch update/id request : {}", request);
        UserUpdateResponse response = userService.updateUserInfo(request);

        // 추후
        //userService.updateRedisUserInfo(response);

        return ResponseEntity.ok(ApiResponse.success(response));
    }


}
