DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS friendship;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS grade;
DROP TABLE IF EXISTS mygame;
DROP TABLE IF EXISTS profile_comment;
DROP TABLE IF EXISTS wish;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS comment;

# 유저 테이블
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    user_id VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL ,
    email VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(50) NOT NULL UNIQUE,
    profile_picture VARCHAR(255),
    role VARCHAR(20) DEFAULT 'ROLE_USER',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

# 친구 관계 테이블
CREATE TABLE friendship (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL ,
    friend_id BIGINT NOT NULL ,
    status VARCHAR(20) NOT NULL,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_friendship_user FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
    CONSTRAINT FK_friendship_friend FOREIGN KEY (friend_id) REFERENCES user(id) ON DELETE CASCADE,
    UNIQUE (user_id, friend_id)
);

# 프로필 테이블
CREATE TABLE profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
#     username VARCHAR(50) NOT NULL UNIQUE ,
    content TEXT,
    user_code BIGINT
);
ALTER TABLE profile ADD CONSTRAINT FK_user_id_profile FOREIGN KEY (user_code) REFERENCES user (id) on delete cascade ;

# 프로필 내 댓글 테이블
CREATE TABLE profile_comment (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                                 user_code BIGINT NOT NULL ,
                                 content TEXT NOT NULL ,
                                 created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 CONSTRAINT FK_user_code_profile_comment FOREIGN KEY (user_code) REFERENCES user(id) ON DELETE CASCADE
);

#게임 테이블
CREATE TABLE game (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                      name VARCHAR(100) NOT NULL UNIQUE ,
                      developer VARCHAR(100) NOT NULL ,
                      publisher VARCHAR(100) NOT NULL ,
                      content TEXT NOT NULL ,
                      price INT NOT NULL ,
                      picture VARCHAR(255) NOT NULL ,
                      sales INT NOT NULL ,
                      discount INT DEFAULT NULL,
                      on_sale boolean NOT NULL DEFAULT TRUE,
                      release_date DATE NOT NULL ,
                      created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
ALTER TABLE game ALTER COLUMN sales set DEFAULT 0;

# 게임 장르 테이블
CREATE TABLE genre (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                       game_code BIGINT NOT NULL ,
                       genre_1 VARCHAR(30),
                       genre_2 VARCHAR(30),
                       genre_3 VARCHAR(30),
                       CONSTRAINT FK_game_code_genre FOREIGN KEY (game_code) REFERENCES game(id) ON DELETE CASCADE
);

# 게임 상세 댓글 테이블
CREATE TABLE grade (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                       content TEXT NOT NULL ,
                       rate boolean,
                       game_code BIGINT NOT NULL ,
                       user_code BIGINT NOT NULL ,
                       created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       CONSTRAINT FK_game_code_grade FOREIGN KEY (game_code) REFERENCES game(id) ON DELETE CASCADE,
                       CONSTRAINT FK_user_code_user FOREIGN KEY (user_code) REFERENCES user(id) ON DELETE CASCADE
);

# 찜 테이블
CREATE TABLE wish (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                      user_code BIGINT NOT NULL ,
                      game_code BIGINT NOT NULL ,
                      CONSTRAINT FK_user_code_wish FOREIGN KEY (user_code) REFERENCES user(id) ON DELETE CASCADE,
                      CONSTRAINT FK_game_code_game FOREIGN KEY (game_code) REFERENCES game(id) ON DELETE CASCADE
);

# 장바구니 테이블
CREATE TABLE cart (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                      user_code BIGINT NOT NULL ,
                      game_code BIGINT NOT NULL ,
                      CONSTRAINT FK_user_code_cart FOREIGN KEY (user_code) REFERENCES user(id) ON DELETE CASCADE ,
                      CONSTRAINT FK_game_code_cart FOREIGN KEY (game_code) REFERENCES game(id) ON DELETE CASCADE
);

# 구매 한 게임 테이블
CREATE TABLE mygame (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                        user_code BIGINT NOT NULL ,
                        game_code BIGINT NOT NULL ,
                        create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT FK_user_code_mygame FOREIGN KEY (user_code) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    user_code BIGINT NOT NULL ,
    game_code BIGINT NOT NULL ,
    tid VARCHAR(255) ,
    price INT,
    status VARCHAR(20) DEFAULT 'READY' NOT NULL ,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_payment_user FOREIGN KEY (user_code) REFERENCES user (id) ON DELETE CASCADE ,
    CONSTRAINT FK_payment_game FOREIGN KEY (game_code) REFERENCES game (id) ON DELETE CASCADE
);

CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    user_to BIGINT NOT NULL ,
    user_from BIGINT NOT NULL ,
    content VARCHAR(255) NOT NULL ,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT FK_comment_to FOREIGN KEY (user_to) REFERENCES user(id) ON DELETE CASCADE ,
    CONSTRAINT FK_comment_FROM FOREIGN KEY (user_from) REFERENCES user(id) ON DELETE CASCADE
);

#  인덱스
CREATE UNIQUE INDEX idx_user_user_id ON user (user_id);
CREATE UNIQUE INDEX idx_user_email ON user (email);
CREATE UNIQUE INDEX idx_user_phone_number ON user (phone_number);

CREATE INDEX idx_friendship_user_friend ON friendship (user_id, friend_id);

CREATE INDEX idx_profile_user_code ON profile (user_code);

CREATE UNIQUE INDEX idx_game_name ON game (name);
CREATE INDEX idx_game_developer ON game (developer);
CREATE INDEX idx_game_publisher ON game (publisher);

CREATE INDEX idx_genre_game_code ON genre (game_code);

CREATE INDEX idx_grade_game_code ON grade (game_code);
CREATE INDEX idx_grade_user_code ON grade (user_code);
CREATE INDEX idx_grade_game_user ON grade (game_code, user_code);

CREATE INDEX idx_wish_user_game ON wish (user_code, game_code);

CREATE INDEX idx_cart_user_game ON cart (user_code, game_code);

CREATE INDEX idx_mygame_user_game ON mygame (user_code, game_code);

CREATE INDEX idx_payment_user_code ON payment (user_code);
CREATE INDEX idx_payment_game_code ON payment (game_code);
CREATE INDEX idx_payment_user_game ON payment (user_code, game_code);

CREATE INDEX idx_comment_user_to ON comment (user_to);
CREATE INDEX idx_comment_user_from ON comment (user_from);
