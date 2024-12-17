package tony.project.steam.domain.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.admin.entity.dto.request.GamePostRequest;
import tony.project.steam.domain.admin.mapper.AdminMapper;
import tony.project.steam.domain.admin.validator.AdminValidator;
import tony.project.steam.domain.game.entity.Game;
import tony.project.steam.domain.game.entity.Genre;
import tony.project.steam.domain.game.mapper.GameMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;
    private final AdminValidator validator;
    private final GameMapper gameMapper;
    @Transactional
    public Long postGame(GamePostRequest request) {
        // 게임 등록
            // 해당 게임이 이미 등록 되었는지 체크
        validator.isExistedGame(request.getName());

        Game newGame = Game.createGame(
                request.getName(),
                request.getDeveloper(),
                request.getPublisher(),
                request.getContent(),
                request.getPrice(),
                request.getPicture(),
                request.getRelease_date()
        );

        // 저장, 로그
        gameMapper.postGame(newGame);
        log.info("[postGame] 새 게임 등록 - {}", newGame.getName());

        return newGame.getId();
    }

    @Transactional
    public void postGameGenre(GamePostRequest request, Long gameCode) {
        validator.gameNotFound(gameCode);

        Genre genre = Genre.builder()
                .game_code(gameCode)
                .genre_1(request.getGenre_1())
                .genre_2(request.getGenre_2())
                .genre_3(request.getGenre_3())
                .build();
        gameMapper.postGenre(gameCode, genre);
        log.info("[postGenre] 새 게임의 장르 등록 - {}, {}", gameCode, genre);
    }
}
