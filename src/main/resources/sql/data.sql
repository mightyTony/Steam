# 더미 데이터 삽입: 게임 테이블
-- 게임 데이터 삽입
INSERT INTO game (name, developer, publisher, content, price, picture, sales, discount, on_sale, release_date)
VALUES
    ('Counter-Strike: Global Offensive', 'Valve', 'Valve', '5대5 팀 기반 전술 슈팅 게임으로, 세계에서 가장 인기 있는 e스포츠 FPS 게임', 19800, '/images/csgo.jpg', 0, 50, true, '2012-08-21'),
    ('Dota 2', 'Valve', 'Valve', '멀티플레이어 온라인 전투 아레나(MOBA) 장르의 전략 게임', 0, '/images/dota2.jpg', 0, 0, true, '2013-07-09'),
    ('Elden Ring', 'FromSoftware', 'Bandai Namco', '오픈 월드 액션 RPG로, 복잡하고 도전적인 전투 시스템을 가진 게임', 64800, '/images/eldenring.jpg', 0, 30, true, '2022-02-25'),
    ('Red Dead Redemption 2', 'Rockstar Games', 'Rockstar Games', '서부 시대를 배경으로 한 오픈 월드 액션 어드벤처 게임', 59800, '/images/rdr2.jpg', 0, 50, true, '2018-10-26'),
    ('Cyberpunk 2077', 'CD Projekt Red', 'CD Projekt', '사이버펑크 테마의 오픈 월드 RPG, 미래 도시 나이트 시티를 배경으로 함', 59800, '/images/cyberpunk2077.jpg', 0, 70, true, '2020-12-10'),
    ('StarCraft II: Wings of Liberty', 'Blizzard Entertainment', 'Blizzard Entertainment', '실시간 전략(RTS) 게임의 대표작으로 한국에서 특히 유명한 e스포츠 게임', 19800, '/images/starcraft2.jpg', 0, 50, true, '2010-07-27'),
    ('World of Warcraft', 'Blizzard Entertainment', 'Blizzard Entertainment', '전 세계에서 가장 유명한 대규모 다중접속 롤플레잉 온라인 게임(MMORPG)', 19800, '/images/wow.jpg', 0, 50, true, '2004-11-23'),
    ('Gears of the Star', 'Klabater', 'Klabater', '우주 탐험과 생존을 다루는 로그라이크 서바이벌 게임', 29800, '/images/gol.jpg', 0, 30, true, '2022-05-24'),
    ('Valheim', 'Iron Gate AB', 'Coffee Stain Publishing', '바이킹 테마의 오픈 월드 생존 및 제작 게임', 26800, '/images/valheim.jpg', 0, 40, true, '2021-02-02'),
    ('Terraria', 'Re-Logic', 'Re-Logic', '2D 샌드박스 어드벤처 및 생존 게임', 16800, '/images/terraria.jpg', 0, 50, true, '2011-05-16'),
    ('Civilization VI', 'Firaxis Games', '2K Games', '세계 최고의 4X 전략 시뮬레이션 게임', 59800, '/images/civilization6.jpg', 0, 75, true, '2016-10-21'),
    ('Street Fighter 6', 'Capcom', 'Capcom', '세계적으로 유명한 격투 게임 시리즈의 최신작', 79800, '/images/sf6.jpg', 0, 20, true, '2023-06-02'),
    ('Final Fantasy VII Remake', 'Square Enix', 'Square Enix', '클래식 RPG의 현대식 리메이크, 현대적 그래픽과 전투 시스템', 79800, '/images/ff7remake.jpg', 0, 50, true, '2020-04-10'),
    ('Horizon Zero Dawn', 'Guerrilla Games', 'Sony Interactive Entertainment', '포스트 아포칼립틱 세계에서 로봇 공룡과 싸우는 액션 RPG', 69800, '/images/horizonzd.jpg', 0, 60, true, '2017-02-28'),
    ('Minecraft', 'Mojang Studios', 'Microsoft', '전 세계에서 가장 유명한 샌드박스 생존 및 제작 게임', 29800, '/images/minecraft.jpg', 0, 20, true, '2011-11-18'),
    ('Apex Legends', 'Respawn Entertainment', 'Electronic Arts', '배틀로얄 장르의 팀 기반 1인칭 슈팅 게임', 0, '/images/apexlegends.jpg', 0, 0, true, '2019-02-04'),
    ('OlliOlli World', 'Roll7', 'Private Division', '스케이트보딩 기술을 중심으로 한 독특한 스포츠 게임', 39800, '/images/olliolli.jpg', 0, 40, true, '2022-02-08'),
    ('Marvel Spider-Man: Miles Morales', 'Insomniac Games', 'Sony Interactive Entertainment', '마블 히어로 스파이더맨의 새로운 주인공의 이야기', 69800, '/images/spidermanmm.jpg', 0, 50, true, '2020-11-12'),
    ('Fortnite', 'Epic Games', 'Epic Games', '세계적으로 유명한 배틀로얄 게임', 0, '/images/fortnite.jpg', 0, 0, true, '2017-07-25'),
    ('Frostpunk', '11 bit studios', '11 bit studios', '포스트 아포칼립틱 도시 생존 전략 게임', 26800, '/images/frostpunk.jpg', 0, 70, true, '2018-04-24'),
    ('Monster Hunter: World', 'Capcom', 'Capcom', '거대 몬스터를 사냥하고 제작하는 액션 RPG', 49800, '/images/mhw.jpg', 0, 75, true, '2018-01-26'),
    ('Diablo IV', 'Blizzard Entertainment', 'Blizzard Entertainment', '액션 RPG의 대표작, 최신작의 다크 판타지 세계', 79800, '/images/diablo4.jpg', 0, 20, true, '2023-06-06'),
    ('This War of Mine', '11 bit studios', '11 bit studios', '전쟁과 생존의 윤리적 선택을 다루는 전략 시뮬레이션', 26800, '/images/this-war-of-mine.jpg', 0, 80, true, '2014-11-14'),
    ('Death Stranding', 'Kojima Productions', 'Sony Interactive Entertainment', '코지마 히데오의 독특한 스토리텔링을 가진 액션 게임', 69800, '/images/deathstranding.jpg', 0, 60, true, '2019-11-08'),
    ('Hogwarts Legacy', 'Avalanche Studios', 'Warner Bros. Interactive Entertainment', '해리 포터 세계를 배경으로 한 오픈 월드 RPG', 79800, '/images/hogwartslegacy.jpg', 0, 20, true, '2023-02-10'),
    ('Satisfactory', 'Coffee Stain Studios', 'Coffee Stain Studios', '공장 건설 및 자동화 관리 시뮬레이션 게임', 39800, '/images/satisfactory.jpg', 0, 30, true, '2019-03-19'),
    ('Twisted Metal', 'Lucid Games', 'Sony Interactive Entertainment', '차량 전투 액션 게임', 59800, '/images/twisted-metal.jpg', 0, 50, true, '2023-02-17'),
    ('Dead Island', 'Deep Silver', 'Deep Silver', '좀비 서바이벌 오픈 월드 게임', 39800, '/images/deadisland.jpg', 0, 70, true, '2011-09-06'),
    ('Tales of Arise', 'Bandai Namco', 'Bandai Namco', '판타지 RPG 액션 게임', 69800, '/images/tales-of-arise.jpg', 0, 60, true, '2021-09-10'),
    ('Metro Exodus', '4A Games', 'Deep Silver', '포스트 아포칼립틱 1인칭 슈팅 게임', 49800, '/images/metro-exodus.jpg', 0, 80, true, '2019-02-15'),
    ('Star Wars Jedi: Fallen Order', 'Respawn Entertainment', 'Electronic Arts', '스타워즈 유니버스의 액션 어드벤처 게임', 59800, '/images/jedi-fallen-order.jpg', 0, 75, true, '2019-11-15'),
    ('Resident Evil Village', 'Capcom', 'Capcom', '공포 서바이벌 게임', 59800, '/images/re-village.jpg', 0, 60, true, '2021-05-07'),
    ('Fallout 4', 'Bethesda Game Studios', 'Bethesda Softworks', '포스트 아포칼립틱 오픈 월드 RPG', 39800, '/images/fallout4.jpg', 0, 75, true, '2015-11-10'),
    ('DOOM Eternal', 'id Software', 'Bethesda Softworks', '초고속 FPS 액션 게임', 59800, '/images/doom-eternal.jpg', 0, 70, true, '2020-03-20'),
    ('Totally Reliable Delivery Service', 'SA-X', 'tinyBuild', '독특한 개념의 시뮬레이션 게임', 19800, '/images/paperjam.jpg', 0, 50, true, '2021-12-02'),
    ('Papers, Please', 'Lucas Pope', 'Lucas Pope', '다큐멘터리 스타일의 서류 검사 게임', 16800, '/images/papers-please.jpg', 0, 50, true, '2013-08-08'),
    ('Factorio', 'Wube Software', 'Wube Software', '자동화 및 공장 건설 시뮬레이션', 39800, '/images/factorio.jpg', 0, 0, true, '2020-08-14'),
    ('Hades', 'Supergiant Games', 'Supergiant Games', '로그라이크 액션 RPG', 39800, '/images/hades.jpg', 0, 30, true, '2020-09-17'),
    ('The Witcher 3: Wild Hunt', 'CD Projekt Red', 'CD Projekt', '판타지 오픈 월드 RPG의 대표작', 39800, '/images/witcher3.jpg', 0, 80, true, '2015-05-19'),
    ('Marvel Spider-Man Remastered', 'Insomniac Games', 'Sony Interactive Entertainment', 'PC 버전의 스파이더맨 게임', 69800, '/images/spiderman-remastered.jpg', 0, 20, true, '2022-08-12'),
    ('Ghost of Tsushima', 'Sucker Punch Productions', 'Sony Interactive Entertainment', '일본 사무라이의 이야기를 다룬 액션 어드벤처', 69800, '/images/ghost-of-tsushima.jpg', 0, 50, true, '2020-07-17'),
    ('Rainbow Six Siege', 'Ubisoft', 'Ubisoft', '전술적 5대5 FPS 게임', 49800, '/images/r6siege.jpg', 0, 70, true, '2015-12-01'),
    ('Dead Space Remake', 'Motive Studio', 'Electronic Arts', '공포 과학 액션 게임의 리메이크', 69800, '/images/dead-space-remake.jpg', 0, 30, true, '2023-01-27'),
    ('DJMAX RESPECT V', 'NEOWIZ', 'NEOWIZ', '최고의 인기 리듬게임 "DJ MAX" 드디어 STEAM 출시 !!!', 49800, 'djmax.jpg', 4000000, 70, TRUE, '2020-03-12');

-- 판매량 수정
UPDATE game
SET sales = CASE
                WHEN name = 'Counter-Strike: Global Offensive' THEN 400000000
                WHEN name = 'Dota 2' THEN 300000000
                WHEN name = 'Elden Ring' THEN 20000000
                WHEN name = 'Red Dead Redemption 2' THEN 50000000
                WHEN name = 'Cyberpunk 2077' THEN 30000000
                WHEN name = 'StarCraft II: Wings of Liberty' THEN 6000000
                WHEN name = 'World of Warcraft' THEN 120000000
                WHEN name = 'Gears of the Star' THEN 2000000
                WHEN name = 'Valheim' THEN 10000000
                WHEN name = 'Terraria' THEN 45000000
                WHEN name = 'Civilization VI' THEN 11000000
                WHEN name = 'Street Fighter 6' THEN 3000000
                WHEN name = 'Final Fantasy VII Remake' THEN 5000000
                WHEN name = 'Horizon Zero Dawn' THEN 2000000
                WHEN name = 'Minecraft' THEN 238000000
                WHEN name = 'Apex Legends' THEN 100000000
                WHEN name = 'OlliOlli World' THEN 1000000
                WHEN name = 'Marvel Spider-Man: Miles Morales' THEN 7000000
                WHEN name = 'Fortnite' THEN 350000000
                WHEN name = 'Frostpunk' THEN 4000000
                WHEN name = 'Monster Hunter: World' THEN 22000000
                WHEN name = 'Diablo IV' THEN 8000000
                WHEN name = 'This War of Mine' THEN 7000000
                WHEN name = 'Death Stranding' THEN 5000000
                WHEN name = 'Hogwarts Legacy' THEN 12000000
                WHEN name = 'Satisfactory' THEN 4000000
                WHEN name = 'Twisted Metal' THEN 2000000
                WHEN name = 'Dead Island' THEN 6000000
                WHEN name = 'Tales of Arise' THEN 4000000
                WHEN name = 'Metro Exodus' THEN 5000000
                WHEN name = 'Star Wars Jedi: Fallen Order' THEN 10000000
                WHEN name = 'Resident Evil Village' THEN 6000000
                WHEN name = 'Fallout 4' THEN 13000000
                WHEN name = 'DOOM Eternal' THEN 8000000
                WHEN name = 'Totally Reliable Delivery Service' THEN 2000000
                WHEN name = 'Papers, Please' THEN 3000000
                WHEN name = 'Factorio' THEN 3500000
                WHEN name = 'Hades' THEN 7000000
                WHEN name = 'The Witcher 3: Wild Hunt' THEN 40000000
                WHEN name = 'Marvel Spider-Man Remastered' THEN 6000000
                WHEN name = 'Ghost of Tsushima' THEN 9000000
                WHEN name = 'Rainbow Six Siege' THEN 70000000
                WHEN name = 'Dead Space Remake' THEN 4000000
    END
WHERE sales = 0;


-- 장르 데이터 삽입
INSERT INTO genre (game_code, genre_1, genre_2, genre_3)
VALUES
    (1, 'FPS', '전술', 'e스포츠'),
    (2, 'MOBA', '전략', '멀티플레이'),
    (3, 'RPG', '액션', '오픈 월드'),
    (4, '액션', '오픈 월드', '어드벤처'),
    (5, 'RPG', '사이버펑크', '오픈 월드'),
    (6, '전략', 'RTS', 'e스포츠'),
    (7, 'MMORPG', '판타지', '오픈 월드'),
    (8, '로그라이크', '서바이벌', '우주 탐험'),
    (9, '생존', '오픈 월드', '바이킹'),
    (10, '샌드박스', '생존', '어드벤처'),
    (11, '전략', '시뮬레이션', '역사'),
    (12, '격투', 'e스포츠', '액션'),
    (13, 'RPG', '액션', '리메이크'),
    (14, '액션', '오픈 월드', '포스트 아포칼립스'),
    (15, '샌드박스', '생존', '크리에이티브'),
    (16, 'FPS', '배틀로얄', '멀티플레이'),
    (17, '스포츠', '스케이트보드', '독특한'),
    (18, '액션', '슈퍼히어로', '스토리 중심'),
    (19, '배틀로얄', '멀티플레이', 'e스포츠'),
    (20, '전략', '생존', '포스트 아포칼립스'),
    (21, '액션', 'RPG', '몬스터 헌팅'),
    (22, 'RPG', '액션', '다크 판타지'),
    (23, '전략', '생존', '전쟁 테마'),
    (24, '액션', '스토리 중심', '서바이벌'),
    (25, 'RPG', '오픈 월드', '판타지'),
    (26, '시뮬레이션', '전략', '자동화'),
    (27, '액션', '전투', '차량'),
    (28, '생존', '좀비', '오픈 월드'),
    (29, 'RPG', '액션', '판타지'),
    (30, 'FPS', '스토리 중심', '포스트 아포칼립스'),
    (31, '액션', '어드벤처', '스타워즈'),
    (32, '공포', '서바이벌', '스토리 중심'),
    (33, 'RPG', '오픈 월드', '포스트 아포칼립스'),
    (34, 'FPS', '액션', '고속 진행'),
    (35, '시뮬레이션', '독특한', '코미디'),
    (36, '퍼즐', '전략', '창의적'),
    (37, '시뮬레이션', '전략', '자동화'),
    (38, '로그라이크', '액션', 'RPG'),
    (39, 'RPG', '오픈 월드', '판타지'),
    (40, '액션', '슈퍼히어로', 'PC 리메이크'),
    (41, '액션', '어드벤처', '사무라이'),
    (42, 'FPS', '전술', 'e스포츠'),
    (43, '공포', '액션', '리메이크'),
    (44, '리듬', '음악', '인기 시리즈');

-- 테스트 조회 쿼리
SELECT
    game.name, game.sales, g.genre_1, g.genre_2, g.genre_3
FROM game
JOIN steam.genre g on game.id = g.`game_code`

