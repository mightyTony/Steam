package tony.project.steam.domain.game.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.game.entity.Grade;

import java.util.List;

@Mapper
public interface GameReviewMapper {
    void postReview(Grade review);

    boolean isAlreadyWrite(@Param("game_code") Long gameCode, @Param("user_code") Long userCode);

    Grade getReview(@Param("user_code") Long userCode, @Param("game_code") Long game_code);

    List<Grade> getReviewPaging(@Param("game_code") Long gameCode,
                                @Param("size") int size,
                                @Param("offset") int offset);
}
