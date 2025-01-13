package tony.project.steam.domain.game.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.game.mapper.GameReviewMapper;

@Component
@Slf4j
@RequiredArgsConstructor
public class GameReviewValidator {

    private final GameReviewMapper gameReviewMapper;

    public boolean isAlreadyWrite(Long gameCode, Long userCode) {
        return gameReviewMapper.isAlreadyWrite(gameCode, userCode);
    }
}
