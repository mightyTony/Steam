package tony.project.steam.domain.game.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.game.entity.Game;
import tony.project.steam.domain.game.entity.Genre;

@Mapper
public interface GameMapper {
    void postGame(Game newGame);

    void postGenre(@Param("gameCode") Long gameCode, @Param("genre") Genre genre);
}
