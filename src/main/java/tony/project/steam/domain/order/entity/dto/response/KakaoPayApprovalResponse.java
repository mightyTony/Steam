package tony.project.steam.domain.order.entity.dto.response;

import lombok.Data;

@Data
public class KakaoPayApprovalResponse {
//    private String aid; // 요청 고유 아이디
    private String tid; // 거래 고유 아이디
//    private String cid; // 제휴사 아이디
//    private String payment_method_type;
    private int total;
//    private int tax_free;
}
