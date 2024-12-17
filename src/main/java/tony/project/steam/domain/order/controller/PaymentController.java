package tony.project.steam.domain.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tony.project.steam.common.ApiResponse;
import tony.project.steam.domain.order.entity.dto.response.KakaoPayApprovalResponse;
import tony.project.steam.domain.order.entity.dto.response.KakaoPayReadyResponse;
import tony.project.steam.domain.order.service.KakaoPayService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
// TODO @PreAuth
public class PaymentController {

    private final KakaoPayService kakaoPayService;

    // 결제 준비
    @PostMapping("/ready")
    public ResponseEntity<ApiResponse<KakaoPayReadyResponse>> payReady(
            @RequestParam("userCode") Long userCode,
            @RequestParam("gameCode") Long gameCode,
            @RequestParam("price") int price) {
        KakaoPayReadyResponse kakaoPayReadyResponse = kakaoPayService.readyPayment(userCode, gameCode, price);

        return ResponseEntity.ok(ApiResponse.success(kakaoPayReadyResponse));
    }

    // 결제 승인
    @GetMapping("/success")
    public ResponseEntity<ApiResponse<KakaoPayApprovalResponse>> successPayment(
            @RequestParam String pg_token,
            @RequestParam Long paymentId) {

        KakaoPayApprovalResponse response = kakaoPayService.approvePayment(paymentId, pg_token);
        return ResponseEntity.ok(ApiResponse.success(response));
    }



}
