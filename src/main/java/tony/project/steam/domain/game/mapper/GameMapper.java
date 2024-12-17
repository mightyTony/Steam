package tony.project.steam.domain.game.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.game.entity.Game;
import tony.project.steam.domain.game.entity.Genre;
import tony.project.steam.domain.game.entity.dto.response.GameDetailResponse;
import tony.project.steam.domain.game.entity.dto.response.GameSearchResponse;

import java.util.List;

@Mapper
public interface GameMapper {
    void postGame(Game newGame);

    void postGenre(@Param("gameCode") Long gameCode, @Param("genre") Genre genre);

    List<GameSearchResponse> getTrendingGames(@Param("size") int size, @Param("offset") int offset);

    List<GameSearchResponse> getNewGames(@Param("size") int size, @Param("offset") int offset);

    List<GameSearchResponse> searchGamesPaging(String keyword, int offset, int size);

    List<GameSearchResponse> searchOnSales(int offset, int size);

    boolean isExistGame(@Param("gameCode") Long gameCode);

    GameDetailResponse getGameDetails(@Param("gameCode") Long gameCode);

    String findGameNameById(Long gameCode);
}
