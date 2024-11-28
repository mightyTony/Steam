package tony.project.steam.domain.profile.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.repository.UserRepository;
import tony.project.steam.domain.auth.service.AuthService;
import tony.project.steam.domain.profile.entity.Friend;
import tony.project.steam.domain.profile.entity.FriendStatus;
import tony.project.steam.domain.profile.repository.FriendRepository;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class FriendServiceTest {

    @Autowired
    private FriendService friendService;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @BeforeEach
    void setUp() {

        log.info("[BEFORE EACH] Create User");
        User user = User.builder()
                .userId("user123")
                .password("1234")
                .email("john@gmail.com")
                .phoneNumber("010-1234-5678")
                .name("John")
                .username("johndoe")
                .profilePicture("default.jpg")
                .build();

        User friend = User.builder()
                .userId("tony")
                .password("1234")
                .email("tony@gmail.com")
                .name("Tony")
                .username("Tony")
                .phoneNumber("010-1234-5672")
                .profilePicture("default.jpg")
                .build();

        userRepository.save(user);
        userRepository.save(friend);
    }

    @AfterEach
    void tearDown() {
        log.info("[AFTER EACH] Delete All");
        friendRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("친구 요청")
//    @Transactional
    void requestFriend() {
        log.info("[친구 요청] me 조회");
        User me = userRepository.findByUserId("user123")
                .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
        log.info("[친구 요청] friend 조회");
        User friend = userRepository.findByUserId("tony")
                .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));

        log.info("[친구 요청] 친구 요청 생성");
        Friend friendship = Friend.builder()
                .user(me)
                .friend(friend)
                .status(FriendStatus.WAITING)
                .build();

        friendRepository.save(friendship);

        Assertions.assertNotNull(friendship);
    }
}