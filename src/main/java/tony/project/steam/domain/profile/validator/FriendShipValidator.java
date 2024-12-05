package tony.project.steam.domain.profile.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.profile.mapper.FriendShipMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

@Component
@Slf4j
@RequiredArgsConstructor
public class FriendShipValidator {

    private final FriendShipMapper friendShipMapper;


    public void isExistRequest(Long friendshipRequestId) {
        if(!friendShipMapper.findFriendRequest(friendshipRequestId)){
            throw new CustomException(ErrorCode.REQUEST_NOT_FOUND);
        }
    }
}
