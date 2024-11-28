package tony.project.steam.domain.profile.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tony.project.steam.domain.auth.entity.User;
import tony.project.steam.domain.profile.repository.FriendRepository;

@Component
@Slf4j
@RequiredArgsConstructor
public class FriendValidator {

    private final FriendRepository friendRepository;


//    public User validate
}
