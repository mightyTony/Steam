package tony.project.steam.domain.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;
import tony.project.steam.domain.auth.service.UserService;

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


}
