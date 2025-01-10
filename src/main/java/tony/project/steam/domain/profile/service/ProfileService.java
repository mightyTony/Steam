package tony.project.steam.domain.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.auth.mapper.UserMapper;
import tony.project.steam.domain.auth.service.UserService;
import tony.project.steam.domain.auth.validator.AuthValidator;
import tony.project.steam.domain.profile.entity.Comment;
import tony.project.steam.domain.profile.entity.MyGame;
import tony.project.steam.domain.profile.entity.UserProfile;
import tony.project.steam.domain.profile.entity.dto.request.CreateCommentRequest;
import tony.project.steam.domain.profile.entity.dto.request.ProfileCreateRequest;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.MyGameResponse;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;
import tony.project.steam.domain.profile.mapper.ProfileMapper;
import tony.project.steam.domain.profile.validator.ProfileValidator;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileMapper profileMapper;
    private final UserService userService;
    private final AuthValidator authValidator;
    private final UserMapper userMapper;
    private final ProfileValidator profileValidator;

    @Transactional
    public ProfileResponse updateMyProfile(Long userCode, ProfileUpdateRequest request) {
        // 1. 유저 조회
        User user = authValidator.isUserExistReturnUser(userCode);
        // 2. 프로필 업데이트
        profileMapper.updateMyProfile(request);
        // 3. 업데이트된 프로필 정보 조회, 반환
        ProfileResponse response = profileMapper.getProfileByUserCode(userCode);

        return response;
    }

    @Transactional
    public void makeProfile(ProfileCreateRequest request) {
        //
        UserProfile profile = UserProfile.createProfile(request.getUser_code(), request.getUsername(), request.getContent());

        profileMapper.saveProfile(profile);
    }

    @Transactional
    public void addMyGame(String item_code, String user_code) {
        Long itemCode = Long.parseLong(item_code);
        Long userCode = Long.parseLong(user_code);

        MyGame myGame = MyGame.intoMyGame(itemCode, userCode);

        profileMapper.addMyGame(myGame);
    }

    public List<MyGameResponse> getMyGames(Long userCode) {

        List<MyGameResponse> my_games = profileMapper.getMyGames(userCode);
        return my_games;
    }

    @Transactional
    public void postComment(Long toUser, CreateCommentRequest request) {

        Comment comment = Comment.makeReply(toUser, request.getUser_from(), request.getContent());
        profileMapper.postComment(comment);
    }

    @Transactional
    public void deleteComment(Long toUser, Long commentId, User user) {
        // 1. 유저 권한 체크(프로필 주인, 댓글 작성자 체크)
        profileValidator.isAuthenticated(toUser, user);
        // 2. 삭제
        profileMapper.deleteComment(commentId);
    }
}
