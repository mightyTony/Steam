package tony.project.steam.domain.wishlist.entity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WishResponse {
    private Long id;
    private Long userCode;
    private Long gameCode;

    // game
    private String name;
    private String publisher;
    private String content;
    private Integer price;
    private String picture;
    private Integer sales;
    private Integer discount; // 할인율
    private boolean on_sale; // 판매 여부
    private Date release_date; // 서비스 시작 일자

    // genre
    private String genre_1;
    private String genre_2;
    private String genre_3;
}
