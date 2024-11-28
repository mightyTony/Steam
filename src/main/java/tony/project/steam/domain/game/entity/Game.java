package tony.project.steam.domain.game.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tony.project.steam.common.BaseTimeEntity;
import tony.project.steam.domain.cart.entity.Cart;
import tony.project.steam.domain.profile.entity.MyGame;
import tony.project.steam.domain.wishlist.entity.WishList;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "game")
public class Game extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_code")
    private Long id;

    @Column(name = "game_name", nullable = false)
    private String name;

    @Column(name = "game_price", nullable = false)
    private String price;

    @Column(name = "game_developer", nullable = false)
    private String developer; // 게임 개발사

    @Column(name = "game_distributor", nullable = false)
    private String distributor; // 게임 유통사

    @Column(name = "game_content", nullable = false)
    @Lob
    private String content; // 게임 설명

    @Column(name = "game_sales", nullable = false)
    private Integer sales; // 판매량

    @Column(name = "game_picture", nullable = false)
    private String picture; // 게임 이미지

    @Column(name = "game_discount")
    private Integer discount; // 할인율

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_code")
    private Genre genre; // 장르

//    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Grade> grades = new ArrayList<>();

//    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Cart> carts = new ArrayList<>();

//    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<WishList> wishLists = new ArrayList<>();

//    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<MyGame> myGames = new ArrayList<>();
}
