package tony.project.steam.domain.game.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Game {
    private Long id;
    private String name;
    private String developer; // 게임 개발사
    private String publisher; // 게임 유통사
    private String content; // 게임 설명
    private Integer price;
    private String picture; // 게임 이미지
    private Integer sales; // 판매량
    private Integer discount; // 할인율
    private boolean on_sale; // 판매 여부
    private Date release_date; // 서비스 시작 일자
    private LocalDateTime created_date; // 생성일자
    private LocalDateTime modified_date; // 수정일자

    public static Game createGame(String name, String developer, String publisher,
                                  String content, Integer price, String picture, Date release_date) {
        Game game = new Game();
        game.name = name;
        game.developer = developer;
        game.publisher = publisher;
        game.content = content;
        game.price = price;
        game.picture = picture;
        game.sales = 0;
        game.discount = 0;
        game.on_sale = true;
        game.release_date = release_date;
        game.created_date = LocalDateTime.now();
        game.modified_date = LocalDateTime.now();
        return game;
    }


}
