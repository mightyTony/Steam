package tony.project.steam.domain.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.auth.entity.User;

import java.util.Optional;

@Mapper
public interface AuthMapper {

    void save(User user);

    Optional<User> findByUserId(String userId);

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByNickname(String nickname);

    Optional<User> findByUserCode(@Param("user_code") Long userCode);
}
