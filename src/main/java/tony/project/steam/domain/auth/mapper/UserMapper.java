package tony.project.steam.domain.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.entity.dto.response.UserSearchResponse;
import tony.project.steam.domain.auth.entity.dto.response.UserUpdateResponse;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserSearchResponse> searchUsersPaging(@Param("keyword") String keyword,
                                               @Param("offset") int offset,
                                               @Param("size") int size);

    int countSearchedUsers(@Param("keyword") String keyword);

    List<UserSearchResponse> getRandomUsers();

    int updateUserInfo(User updatedInfo);
}
