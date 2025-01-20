# 목차
1. [ERD 구조](#1-erd-구조)
2. [기술 스택](#2-기술-스택)
3. [주요 기능](#3-주요-기능)
    - [공통](#공통)
    - [사용자](#사용자)
    - [관리자](#관리자)
4. [API 명세](#4-api-명세)

---

## 1. ERD 구조
![erd](https://github.com/user-attachments/assets/a2aba8da-3808-4450-9a1d-46fdd7bd35ac)

---

## 2. 기술 스택
Spring Boot 3.x, MySQL, Mybatis, Redis, Spring Security, JWT, Docker

---

## 3. 주요 기능
### 공통
- 회원가입 (`Auth`)
    - 회원 가입
    - 로그인
    - 로그아웃
- 상품 목록 및 상품 상세 조회 (`게임`)
    - 게임 등록
    - 게임 검색
    - 게임 목록
    - 할인 게임 목록
    - 인기 게임 목록
    - 최신 게임 목록
    - 동적 쿼리
    - 상세조회
        - 상세조회
        - 장바구니 추가
        - 바로 구매
        - 상세 설명
        - 평점 / 댓글 조회
        - 평점 / 댓글 등록

### 사용자
- **프로필**
    - **친구**
        - 친구 목록
        - 친구 요청 확인
        - 친구 삭제
        - 유저 검색 (친구 이전)
        - 랜덤 유저 리스트 (5명)
    - **회원정보**
        - 정보 수정
    - **자기소개**
        - 자기소개 수정
    - **구매한 게임 목록**
- **댓글**
    - 댓글 등록
    - 댓글 수정
    - 댓글 삭제
- **찜**
    - 찜 등록 / 응답 찜 게임
    - 찜 목록
    - 장바구니 추가 / 이동
    - 찜 목록 게임 삭제
- **장바구니**
    - 구매하기
    - 목록 삭제

### 관리자
- **상품 및 상품 카테고리 관리**
    - 게임 등록
- **옵션 및 옵션 카테고리 관리**
- **주문 관리**
    - 구매하기 (`장바구니` API 포함)

---

## 4. API 명세
| Domain           | URL                                         | HTTP Method | Description                              | 접근 권한 |
|------------------|---------------------------------------------|-------------|------------------------------------------|-----------|
| **Auth**         | /api/v1/auth/join                          | POST        | 사용자 회원가입                          | -         |
|                  | /api/v1/auth/login                         | POST        | 로그인                                   | -         |
|                  | /api/v1/auth/logout                        | POST        | 로그아웃                                 | USER      |
|                  | /api/v1/auth/refresh                       | POST        | Access Token 재발급                      | USER      |
| **User**         | /api/v1/user/update/{id}                   | PATCH       | 회원 정보 수정                           | USER      |
|                  | /api/v1/user/search                        | GET         | 유저 검색                                | USER      |
|                  | /api/v1/user/random                        | GET         | 랜덤 유저 리스트 (5명)                   | USER      |
| **Friendship**   | /api/v1/profile/friendship/request         | POST        | 친구 요청                                | USER      |
|                  | /api/v1/profile/friendship/request/{id}    | PATCH       | 친구 요청 수락/거절                      | USER      |
|                  | /api/v1/profile/friendship/{id}/list       | GET         | 친구 목록 조회                           | USER      |
|                  | /api/v1/profile/friendship/requests        | GET         | 친구 요청 조회                           | USER      |
|                  | /api/v1/profile/friendship/{id}            | DELETE      | 친구 삭제                                | USER      |
| **Wish**         | /api/v1/wish/add                           | POST        | 찜 목록 추가                             | USER      |
|                  | /api/v1/wish/{id}                          | GET         | 내 찜 목록 조회                          | USER      |
|                  | /api/v1/wish/{user_code}/{game_code}       | DELETE      | 찜 삭제                                  | USER      |
| **Review**       | /api/v1/review/post                        | POST        | 리뷰 등록                                | USER      |
|                  | /api/v1/review                             | GET         | 리뷰 조회                                | USER      |
| **Profile**      | /api/v1/profile/{id}/comment/post          | POST        | 댓글 등록                                | USER      |
|                  | /api/v1/profile/{id}                       | PATCH       | 프로필 정보 수정                         | USER      |
|                  | /api/v1/profile/{id}/comment/{comment_id}  | PATCH       | 댓글 수정                                | USER      |
|                  | /api/v1/profile/{id}/games                 | GET         | 내 게임 목록 출력                        | USER      |
|                  | /api/v1/profile/{user}/comment/{id}        | DELETE      | 댓글 삭제                                | USER      |
| **Payment**      | /api/v1/payment/ready                      | POST        | 결제 준비                               | USER      |
|                  | /api/v1/payment/success                    | GET         | 결제 완료 확인                           | USER      |
| **Admin**        | /api/v1/admin/game/post                    | POST        | 게임 등록                                | ADMIN     |
| **Game**         | /api/v1/game/explore/{id}                  | GET         | 게임 상세 조회                           | USER      |
|                  | /api/v1/game/explore/trend                 | GET         | 인기 게임 목록 조회                      | USER      |
|                  | /api/v1/game/explore/search                | GET         | 게임 검색                                | USER      |
|                  | /api/v1/game/explore/sale                  | GET         | 할인 중인 게임 목록 조회                 | USER      |
|                  | /api/v1/game/explore/news                  | GET         | 신작 게임 목록 조회                      | USER      |

## 5. 문제 / 해결
- 총 판매가 많으면 인기 게임 인가? 
    - 그렇지 않다. 기준을 월간 인기 게임으로 바꿔서 실시간 순위 변동이 아닌
      월간 배치로 인기 게임 페이징 순서를 처리 한다.
- 인기 게임, 신작 게임 정보 조회는 접속 할 때마다 똑같은 결과를 여러번 서버, DB에 요청 할 것으로 예상된다.
    - 인기 게임, 신작 게임 정보와 같이 잦은 변동이 없어 보이는 조회는 Redis에 저장해서 캐시 미스 시에만 DB에서 조회되게 설계를 하여 DB 과부하를 줄임.
