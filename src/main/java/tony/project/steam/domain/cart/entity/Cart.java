//package tony.project.steam.domain.cart.entity;
//
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import tony.project.steam.domain.auth.entity.User;
//import tony.project.steam.domain.game.entity.Game;
//
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@Table(name = "cart")
//public class Cart {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cart_code")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_code", nullable = false)
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "game_code", nullable = false)
//    private Game game;
//
//    @Column(name = "total_price", nullable = false)
//    private Integer totalPrice;
//
//    public static Cart createCart(User user, Game game) {
//        Cart cart = new Cart();
//        cart.user = user;
//        cart.game = game;
//        cart.totalPrice = Integer.parseInt(game.getPrice());
//
//        return cart;
//    }
//}
