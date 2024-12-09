package tony.project.steam.domain.admin.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.admin.mapper.AdminMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@Slf4j
@RequiredArgsConstructor
public class AdminValidator {

    private final AdminMapper adminMapper;
    public void isExistedGame(String gameName) {
        if(adminMapper.existCheckByGameName(gameName)){
            throw new CustomException(ErrorCode.GAME_ALREADY_EXIST);
        }
    }

    public void gameNotFound(Long gameCode) {
        if(gameCode == null) {
            log.error("게임 장르 등록 안됨 게임코드 - {}", gameCode);
            throw new CustomException(ErrorCode.GAME_NOT_FOUND);
        }
    }
}
