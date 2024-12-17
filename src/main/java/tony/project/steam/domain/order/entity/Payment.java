package tony.project.steam.domain.order.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Payment {
    private Long id;
    private Long userCode;
    private Long gameCode;
    private String tid;
    private int price;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public Payment(Long userCode, Long gameCode, String tid, int price, String status, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.userCode = userCode;
        this.gameCode = gameCode;
        this.tid = tid;
        this.price = price;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
