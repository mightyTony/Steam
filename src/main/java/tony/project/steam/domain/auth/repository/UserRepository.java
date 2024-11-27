package tony.project.steam.domain.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tony.project.steam.domain.auth.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

//    @Query("SELECT u FROM User u WHERE u.userId = :userId OR u.email =: email")
//    boolean existsByUserIdOrEmail(String userId, String email);

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);

}
