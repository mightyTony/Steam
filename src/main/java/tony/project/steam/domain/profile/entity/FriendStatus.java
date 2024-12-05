package tony.project.steam.domain.profile.entity;

public enum FriendStatus {
    WAITING,
    ACCEPTED,
    REJECTED;

    public String getValue() {
        return super.toString();
    }
}
