package tony.project.steam.domain.profile.entity;

import lombok.Getter;

public enum FriendStatus {
    WAITING,
    ACCEPTED,
    REJECTED;

    public String getValue() {
        return super.toString();
    }
}
