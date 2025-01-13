package tony.project.steam.domain.game.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.game.entity.Grade;
import tony.project.steam.domain.game.entity.dto.request.CreateGameReviewRequest;
import tony.project.steam.domain.game.service.GameReviewService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class GameReviewController {
    private final GameReviewService gameReviewService;

    @PostMapping("/post")
    public ResponseEntity<ApiResponse<Grade>> postGameReview(@RequestBody @Valid CreateGameReviewRequest request,
                                                            @AuthenticationPrincipal User user) {
        gameReviewService.postGameReview(request, user);

        Grade review = gameReviewService.getGameReview(request.getGame_code(), user.getId());

        return ResponseEntity.ok(ApiResponse.success(review));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<Page<Grade>>> getGameReviews(@RequestParam("game_code") Long gameCode,
                                                                   @RequestParam(defaultValue = "1") int page,
                                                                   @RequestParam(defaultValue = "10") int size
                                                                   ) {
        Page<Grade> reviews = gameReviewService.getGameReviewPaging(gameCode, page, size);

        return ResponseEntity.ok(ApiResponse.success(reviews));
    }
}
