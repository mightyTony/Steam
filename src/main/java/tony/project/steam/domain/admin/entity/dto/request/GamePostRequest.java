package tony.project.steam.domain.admin.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;

@Data
@Schema(description = "게임 테스트 값")
public class GamePostRequest {
    @Schema(description = "게임 이름", example = "Cyberpunk 2077")
    private String name;
    @Schema(description = "개발자", example = "CD Projekt Red")
    private String developer;
    @Schema(description = "배급사", example = "CD Projekt")
    private String publisher;
    @Schema(description = "게임 설명", example = "나이트 시티가 당신을 바꿔 놓을 것입니다\n" +
            "\n" +
            "사이버펑크 2077은 권력, 사치와 신체 개조에 집착하는 거대 도시 나이트 시티를 배경으로 한 오픈 월드, 액션 어드벤처 게임입니다. 당신은 무법자 용병 V가 되어, 유일무이한 불멸의 열쇠를 뒤쫓고 있습니다. 당신은 사이버웨어와 다양한 능력, 플레이스타일을 변경할 수 있고, 거대한 도시를 탐험하며 당신의 선택과 결정이 스토리의 전개뿐만 아니라 당신을 감싸고 있는 이 세계에 어떤 영향을 미치는지 확인할 수 있습니다.")
    private String content;
    @Schema(description = "가격", example = "66000")
    private Integer price;
    @Schema(description = "URL", example = "Cyberpunk.jpg")
    private String picture;
    @Schema(description = "출시일", example = "2020-12-10")
    private Date release_date;

    @Schema(description = "장르1", example = "액션")
    private String genre_1;
    @Schema(description = "장르2", example = "어드벤처")
    private String genre_2;
    @Schema(description = "장르3", example = "RPG")
    private String genre_3;

}
