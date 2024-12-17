package tony.project.steam.domain.game.entity.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class GameSearchResponse {
    private Long id;
    private String name;
    private String picture;
    private Integer price;
    private Integer discount;
    private Date release_date;
    private String genre_1;
    private String genre_2;
    private String genre_3;


}
