package tony.project.steam.domain.game.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tony.project.steam.domain.game.entity.dto.response.GameDetailResponse;
import tony.project.steam.domain.game.entity.dto.response.GameSearchResponse;
import tony.project.steam.domain.game.mapper.GameMapper;
import tony.project.steam.domain.game.validator.GameValidator;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GameService {

    private final GameValidator gameValidator;
    private final GameMapper gameMapper;

    private int calculateOffset(int page, int size) {
        return (page - 1) * size;
    }

    // 인기 제품 리스트 페이징
    public Page<GameSearchResponse> getTrendingGamesPaging(int page, int size) {
        int offset = calculateOffset(page, size);

        // 데이터 조회
        List<GameSearchResponse> result = gameMapper.getTrendingGames(size,offset);
        long total = result.size();

        Pageable pageable = PageRequest.of(page - 1,size);

        return new PageImpl<>(result, pageable, total);

    }

    // 신작 리스트 페이징
    public Page<GameSearchResponse> getNewGamesPaging(int page, int size) {
        int offset = calculateOffset(page, size);

        List<GameSearchResponse> result = gameMapper.getNewGames(size, offset);
        long total = result.size();

        Pageable pageable = PageRequest.of(page - 1, size);

        return new PageImpl<>(result, pageable, total);
    }

    public Page<GameSearchResponse> searchGamesPaging(String keyword, int page, int size) {
        int offset = calculateOffset(page, size);

        // 데이터 조회
        List<GameSearchResponse> games = gameMapper.searchGamesPaging(keyword,offset,size);
        //
        int totalGames = games.size();

        // 객체
        Pageable pageable = PageRequest.of(page -1, size);

        return new PageImpl<>(games, pageable, totalGames);
    }


    public Page<GameSearchResponse> searchOnSaleGames(int page, int size) {
        int offset = calculateOffset(page, size);

        List<GameSearchResponse> games = gameMapper.searchOnSales(offset,size);
        int total = games.size();

        Pageable pageable = PageRequest.of(page - 1,size);

        return new PageImpl<>(games,pageable,total);
    }

    public GameDetailResponse getGameDetails(Long gameCode) {
        // 존재 체크
        gameValidator.isExistGameCode(gameCode);

        return gameMapper.getGameDetails(gameCode);
    }
}
