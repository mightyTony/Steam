package tony.project.steam.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // ACCOUNT
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "ACCOUNT-001", "사용자를 찾을 수 없습니다."),
    USERNAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "ACCOUNT-002", "이미 존재하는 사용자명입니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "ACCOUNT-003", "이미 존재하는 이메일입니다."),
    PHONE_NUMBER_ALREADY_EXISTS(HttpStatus.CONFLICT, "ACCOUNT-004" , "이미 등록된 휴대전화 번호 입니다" ),

    // AUTH
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "AUTH-001", "아이디 또는 비밀번호가 일치하지 않습니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.FORBIDDEN, "AUTH-002", "유효하지 않거나 만료된 Refresh Token"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN,"AUTH-003", "접근 권한이 없습니다." ),

    // Friend
    ALREADY_REQUESTED(HttpStatus.BAD_REQUEST, "FRIENDSHIP-001" ,"이미 친구 관계 이거나 친구 요청이 있습니다." ),
    REQUEST_NOT_FOUND(HttpStatus.BAD_REQUEST,"FREIENDSHIP-002" , "존재 하지 않은 요청 입니다."),

    // GAME
    GAME_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "GAME-001" ,"이미 등록 된 게임 입니다." ),
    GAME_NOT_FOUND(HttpStatus.BAD_REQUEST,"GAME-002" , "없는 게임 입니다."),

    // 결제
    PAYMENT_NOT_FOUND(HttpStatus.BAD_REQUEST,"PAYMENT-001" ,"결제 TID를 찾을 수 없습니다"),
    PAYMENT_HAS_NO_RESPONSE(HttpStatus.BAD_REQUEST,"PAYMENT-002" , "카카오페이 API 응답 없음"),

    // 찜
    ALREADY_IN_WISH(HttpStatus.BAD_REQUEST, "WISH-001","이미 찜 목록에 있습니다"),
    WISH_IS_NOT_DELETED(HttpStatus.INTERNAL_SERVER_ERROR, "WISH-002", "찜 목록이 삭제 되지 않았습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
