package tony.project.steam.domain.game.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.game.entity.Grade;
import tony.project.steam.domain.game.entity.dto.request.CreateGameReviewRequest;
import tony.project.steam.domain.game.mapper.GameReviewMapper;
import tony.project.steam.domain.game.validator.GameReviewValidator;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameReviewService {
    private final GameReviewMapper reviewMapper;
    private final GameReviewValidator gameReviewValidator;
    private final GameService gameService;

    @Transactional
    public void postGameReview(CreateGameReviewRequest request, User user) {
        // 1. 이미 리뷰 작성했는지 체크
        if(gameReviewValidator.isAlreadyWrite(request.getGame_code(), user.getId())){
            throw new CustomException(ErrorCode.ALREADY_WRITE_REVIEW);
        }

        Grade review = Grade.createReview(
                request.getGame_code(),
                user.getId(),
                request.getContent(),
                request.getRate()
        );

        reviewMapper.postReview(review);
        log.info("[postGameReview] review : {}", review);
    }

    public Grade getGameReview(Long user_code, Long game_code) {
        return reviewMapper.getReview(user_code, game_code);
    }

    public Page<Grade> getGameReviewPaging(Long gameCode, int page, int size) {

        int offset = gameService.calculateOffset(page, size);

        List<Grade> result = reviewMapper.getReviewPaging(gameCode, size, offset);
        long total = result.size();

        Pageable pageable = PageRequest.of(page -1, size);

        return new PageImpl<>(result, pageable, total);
    }
}

