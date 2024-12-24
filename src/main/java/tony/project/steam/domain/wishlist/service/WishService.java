package tony.project.steam.domain.wishlist.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.game.service.GameService;
import tony.project.steam.domain.wishlist.entity.Wish;
import tony.project.steam.domain.wishlist.entity.dto.response.WishResponse;
import tony.project.steam.domain.wishlist.mapper.WishMapper;
import tony.project.steam.domain.wishlist.validator.WishValidator;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishService {

    private final GameService gameService;
    private final WishMapper wishMapper;
    private final WishValidator wishValidator;

    @Transactional
    public WishResponse addGameInWish(Long userCode, Long gameCode) {
        // 1. 찜 목록에 이미 존재하는지 체크
        wishValidator.isAlreadyIn(userCode,gameCode);

        // 2. 추가
        Wish wish = Wish.builder()
                .userCode(userCode)
                .gameCode(gameCode)
                .build();
        wishMapper.addItemInWishCart(wish);

        // 3. 리턴
        WishResponse response = wishMapper.getWishByUserCodeAndGameCode(userCode, gameCode);

        return response;
    }

    public Page<WishResponse> getMyWishListPaging(Long userCode, int page, int size) {
        int offset = gameService.calculateOffset(page, size);

        List<WishResponse> result = wishMapper.getMyWishGames(userCode,size,offset);
        long total = result.size();

        Pageable pageable = PageRequest.of(page-1, size);

        return new PageImpl<>(result, pageable, total);
    }

    public void deleteMyWishItem(Long userCode, Long gameCode) {
        // 1. 찜한 게임 삭제
        wishMapper.deleteMyWish(userCode, gameCode);

        // 2. 삭제 유효성 체크
        wishValidator.isDeleted(userCode,gameCode);
    }
}
