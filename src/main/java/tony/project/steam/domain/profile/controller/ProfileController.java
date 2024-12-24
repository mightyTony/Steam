package tony.project.steam.domain.profile.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;
import tony.project.steam.domain.profile.service.ProfileService;

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

}
