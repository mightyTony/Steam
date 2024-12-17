package tony.project.steam.domain.game.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.game.mapper.GameMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameValidator {
    private final GameMapper gameMapper;

    public void isExistGameCode(Long gameCode) {
        if(!gameMapper.isExistGame(gameCode)) {
            throw new CustomException(ErrorCode.GAME_NOT_FOUND);
        }
    }

    public String findGameNameById(Long gameCode) {
        String gameName = gameMapper.findGameNameById(gameCode);
        if(gameName == null) {
            throw new CustomException(ErrorCode.GAME_NOT_FOUND);
        }
        return gameName;
    }
}
