package tony.project.steam.domain.auth.entity.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원가입 요청 데이터")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JoinRequest {
    @Schema(description = "사용자 아이디", example = "user123")
    private String userId;

    @Schema(description = "사용자 이름", example = "johndoe")
    private String username;

    @Schema(description = "비밀번호", example = "password123")
    private String password;

    @Schema(description = "이름", example = "John Doe")
    private String name;

    @Schema(description = "이메일 주소", example = "john.doe@example.com")
    private String email;

    @Schema(description = "전화번호", example = "010-1234-5678")
    private String phoneNumber;
}
