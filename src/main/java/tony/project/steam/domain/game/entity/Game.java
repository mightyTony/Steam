package tony.project.steam.domain.game.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Game {
    private Long id;
    private String name;
    private String developer; // 게임 개발사
    private String distributor; // 게임 유통사
    private String content; // 게임 설명
    private Integer price;
    private String picture; // 게임 이미지
    private Integer sales; // 판매량
    private Integer discount; // 할인율
    private boolean on_sale; // 판매 여부
    private LocalDateTime created_date; // 생성일자
    private LocalDateTime modified_date; // 수정일자

    public static Game createGame(String name, String developer, String distributor,
                                  String content, Integer price, String picture,
                                  Integer sales, Integer discount, boolean on_sale) {
        Game game = new Game();
        game.name = name;
        game.developer = developer;
        game.distributor = distributor;
        game.content = content;
        game.price = price;
        game.picture = picture;
        game.sales = sales;
        game.discount = discount;
        game.on_sale = on_sale;
        game.created_date = LocalDateTime.now();
        game.modified_date = LocalDateTime.now();
        return game;
    }
}
