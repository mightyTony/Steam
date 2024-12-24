package tony.project.steam.domain.wishlist.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.wishlist.mapper.WishMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@Slf4j
@RequiredArgsConstructor
public class WishValidator {
    private final WishMapper wishMapper;
    public void isAlreadyIn(Long userCode, Long gameCode) {
        if(wishMapper.findWish(userCode, gameCode)) {
            throw new CustomException(ErrorCode.ALREADY_IN_WISH);
        }
    }

    public void isDeleted(Long userCode, Long gameCode) {
        if(wishMapper.isDeleted(userCode,gameCode)){
            throw new CustomException(ErrorCode.WISH_IS_NOT_DELETED);
        }
    }
}
