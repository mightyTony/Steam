package tony.project.steam.domain.profile.mapper;

import org.apache.ibatis.annotations.Mapper;
import tony.project.steam.domain.profile.entity.UserProfile;
import tony.project.steam.domain.profile.entity.dto.request.ProfileUpdateRequest;
import tony.project.steam.domain.profile.entity.dto.response.ProfileResponse;

@Mapper
public interface ProfileMapper {

    void updateMyProfile(ProfileUpdateRequest request);

    ProfileResponse getProfileByUserCode(Long userCode);

    void saveProfile(UserProfile profile);
}
