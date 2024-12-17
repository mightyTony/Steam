package tony.project.steam.domain.game.entity.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class GameDetailResponse {
    private Long id;
    private String name;
    private String developer; // 개발사
    private String publisher; // 게임 유통사
    private String content; // 게임 설명
    private Integer price;
    private String picture; // 게임 이미지
    private Integer sales; // 판매량
    private Integer discount; // 할인율
    private boolean on_sale; // 판매 여부
    private Date release_date; // 서비스 시작 일자
    private String genre_1;
    private String genre_2;
    private String genre_3;
}
