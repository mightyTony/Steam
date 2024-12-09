package tony.project.steam.domain.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.admin.entity.dto.request.GamePostRequest;
import tony.project.steam.domain.admin.service.AdminService;

@RestController
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;


    // 상품 등록 api
    @PostMapping("/game/post")
    public ResponseEntity<ApiResponse<Void>> postGame(@Valid @RequestBody GamePostRequest request) {

        // 게임 등록
        Long gameCode = adminService.postGame(request);
        // 해당 게임 장르 등록
        adminService.postGameGenre(request, gameCode);
        return ResponseEntity.ok(ApiResponse.success());
    }

    //TODO
    // 상품 할인 api

    //TODO
    // 상품 삭제
}
