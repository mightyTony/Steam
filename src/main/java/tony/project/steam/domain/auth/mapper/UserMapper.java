package tony.project.steam.domain.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserSearchResponse> searchUsersPaging(@Param("keyword") String keyword,
                                               @Param("offset") int offset,
                                               @Param("size") int size);

    int countSearchedUsers(@Param("keyword") String keyword);

    List<UserSearchResponse> getRandomUsers();
}
