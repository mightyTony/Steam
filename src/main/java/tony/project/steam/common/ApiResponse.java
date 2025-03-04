package tony.project.steam.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ApiResponse<T> {

    private boolean success = true;
    private T data;
    private String message;
    private String errorCode;
    private final LocalDateTime timestamp = LocalDateTime.now();

    // 성공 응답 생성자
    public ApiResponse(T data, String message) {
        this.success = true;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(T data) {
        this.success = true;
        this.data = data;
    }

    public ApiResponse(String message, String errorCode) {
        this.success = true;
        this.message = message;
        this.errorCode = errorCode;
    }

    // 성공 응답 생성
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }

    // 실패 응답
    public static <T> ApiResponse<T> fail(String message, String errorCode) {
        return new ApiResponse<>(message, errorCode);
    }

}
