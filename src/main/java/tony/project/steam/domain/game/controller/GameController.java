package tony.project.steam.domain.game.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.game.entity.dto.response.GameDetailResponse;
import tony.project.steam.domain.game.entity.dto.response.GameSearchResponse;
import tony.project.steam.domain.game.service.GameService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/game")
public class GameController {
    private final GameService gameService;

    @Operation(summary = "인기 게임")
    @GetMapping("/explore/trend")
    public ResponseEntity<ApiResponse<Page<GameSearchResponse>>> getTrendingGames(@RequestParam(defaultValue = "1") int page,
                                                                                  @RequestParam(defaultValue = "10") int size) {
        Page<GameSearchResponse> trends = gameService.getTrendingGamesPaging(page, size);

        return ResponseEntity.ok(ApiResponse.success(trends));
    }

    @Operation(summary = "신작 게임")
    @GetMapping("/explore/news")
    public ResponseEntity<ApiResponse<Page<GameSearchResponse>>> getNewGames(@RequestParam(defaultValue = "1") int page,
                                                                             @RequestParam(defaultValue = "10") int size) {
        Page<GameSearchResponse> news = gameService.getNewGamesPaging(page,size);

        return ResponseEntity.ok(ApiResponse.success(news));
    }

    @Operation(summary = "게임 검색")
    @GetMapping("/explore/search")
    public ResponseEntity<ApiResponse<Page<GameSearchResponse>>> searchGames(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<GameSearchResponse> result = gameService.searchGamesPaging(keyword, page, size);

        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @Operation(summary = "할인 중인 게임")
    @GetMapping("/explore/sale")
    public ResponseEntity<ApiResponse<Page<GameSearchResponse>>> searchOnSalesGames(@RequestParam(defaultValue = "1") int page,
                                                                                    @RequestParam(defaultValue = "10") int size) {
        Page<GameSearchResponse> result = gameService.searchOnSaleGames(page, size);

        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @Operation(summary = "상세 조회")
    @GetMapping("/explore/{id}")
    public ResponseEntity<ApiResponse<GameDetailResponse>> getGameDetails(@PathVariable("id") Long gameCode) {

        GameDetailResponse response = gameService.getGameDetails(gameCode);

        return ResponseEntity.ok(ApiResponse.success(response));
    }




}
