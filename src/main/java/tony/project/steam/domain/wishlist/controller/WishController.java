package tony.project.steam.domain.wishlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.wishlist.entity.dto.request.WishRequest;
import tony.project.steam.domain.wishlist.entity.dto.response.WishResponse;
import tony.project.steam.domain.wishlist.service.WishService;

@RestController
@RequestMapping("/api/v1/wish")
@RequiredArgsConstructor
@Slf4j
public class WishController {
    private final WishService wishService;

    @Operation(summary = "찜 목록 추가")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<WishResponse>> addGameInWish(@RequestBody WishRequest request) {

        WishResponse wish = wishService.addGameInWish(request.getUserCode(), request.getGameCode());
        return ResponseEntity.ok(ApiResponse.success(wish));
    }

    @Operation(summary = "내 찜 목록 조회")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Page<WishResponse>>> getMyWish(
            @PathVariable("id") Long userCode,
            @RequestParam(defaultValue = "1")  int page,
            @RequestParam(defaultValue = "30") int size){

        Page<WishResponse> wishes = wishService.getMyWishListPaging(userCode, page, size);

        return ResponseEntity.ok(ApiResponse.success(wishes));
    }

    @Operation(summary = "찜 삭제")
    @DeleteMapping("/{user_code}/{game_code}")
    public ResponseEntity<ApiResponse<Void>> deleteMyWishItem(@PathVariable("user_code") Long userCode,
                                                              @PathVariable("game_code") Long gameCode) {

        wishService.deleteMyWishItem(userCode,gameCode);

        return ResponseEntity.ok(ApiResponse.success());

    }

}
