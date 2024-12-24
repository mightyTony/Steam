package tony.project.steam.domain.wishlist.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import tony.project.steam.domain.wishlist.entity.Wish;
import tony.project.steam.domain.wishlist.entity.dto.response.WishResponse;

import java.util.List;

@Mapper
public interface WishMapper {
    void addItemInWishCart(Wish wish);

    boolean findWish(@Param("user_code") Long userCode, @Param("game_code") Long gameCode);

    WishResponse getWishByUserCodeAndGameCode(@Param("userCode") Long userCode, @Param("gameCode") Long gameCode);

    List<WishResponse> getMyWishGames(@Param("user_code") Long userCode,
                                      @Param("size") int size,
                                      @Param("offset") int offset);

    void deleteMyWish(@Param("user_code") Long userCode, @Param("game_code") Long gameCode);

    boolean isDeleted(@Param("user_code") Long userCode, @Param("game_code") Long gameCode);
}
