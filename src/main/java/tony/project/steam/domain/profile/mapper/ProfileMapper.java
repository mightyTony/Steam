package tony.project.steam.domain.profile.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tony.project.steam.domain.profile.entity.Comment;
import tony.project.steam.domain.profile.entity.MyGame;
import tony.project.steam.domain.profile.entity.UserProfile;
import tony.project.steam.domain.profile.entity.dto.request.CreateCommentRequest;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.MyGameResponse;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;

import java.util.List;

@Mapper
public interface ProfileMapper {

    void updateMyProfile(ProfileUpdateRequest request);

    ProfileResponse getProfileByUserCode(Long userCode);

    void saveProfile(UserProfile profile);

    void addMyGame(MyGame myGame);

    List<MyGameResponse> getMyGames(@Param("user_code") Long userCode);

    void postComment(Comment comment);

    boolean isAuthenticated(@Param("to") Long toUser, Long id);

    void deleteComment(@Param("id") Long commentId);

    int updateComment(@Param("to") Long toUser, @Param("comment_id") Long commentId, @Param("content") String content);

    Comment getCommentById(@Param("comment_id") Long commentId);
}
