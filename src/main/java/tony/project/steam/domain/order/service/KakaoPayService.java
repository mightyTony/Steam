package tony.project.steam.domain.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import tony.project.steam.domain.game.validator.GameValidator;
import tony.project.steam.domain.order.entity.Payment;
import tony.project.steam.domain.order.entity.dto.request.ApproveRequest;
import tony.project.steam.domain.order.entity.dto.request.ReadyRequest;
import tony.project.steam.domain.order.entity.dto.response.KakaoPayApprovalResponse;
import tony.project.steam.domain.order.entity.dto.response.KakaoPayReadyResponse;
import tony.project.steam.domain.order.mapper.PaymentMapper;
import tony.project.steam.exception.CustomException;
import tony.project.steam.exception.ErrorCode;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoPayService {
    @Value("${kakaopay.secret-key}")
    private String secretkey;

    @Value("${kakaopay.cid}")
    private String cid;

    @Value("${kakaopay.url}")
    private String KakaoPayUrl;

    @Value("${sampleHost}")
    private String sampleHost;

    private final RestTemplate restTemplate;
    private final GameValidator gameValidator;
    private final PaymentMapper paymentMapper;

    // 카카오 요구 헤더
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretkey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Transactional
    public KakaoPayReadyResponse readyPayment(Long userCode, Long gameCode, int price) {
        // 1. 게임 이름 가져오기
        String gameName = gameValidator.findGameNameById(gameCode);

        // 2. Payment 저장
        Payment payment = Payment.builder()
                .userCode(userCode)
                .gameCode(gameCode)
                .status("READY")
                .build();
        paymentMapper.savePayment(payment);

        // 3. 카카오페이 결제 준비 요청 데이터 생성
        ReadyRequest requestBody = ReadyRequest.builder()
                .cid(cid)
                .partnerOrderId(payment.getId().toString())
                .partnerUserId(userCode.toString())
                .itemName(gameName)
                .quantity(1)
                .totalAmount(price)
                .taxFreeAmount(0)
                .vatAmount(0)
                .approvalUrl(sampleHost + "/api/v1/payment/success?paymentId=" + payment.getId())
                .cancelUrl(sampleHost + "/api/v1/payment/cancel")
                .failUrl(sampleHost + "/api/v1/payment/fail")
                .build();

        // 4. 카카오페이 Ready API 호출
        HttpEntity<ReadyRequest> requestEntity = new HttpEntity<>(requestBody, getHeaders());
        ResponseEntity<KakaoPayReadyResponse> responseEntity = restTemplate.postForEntity(
                KakaoPayUrl + "/ready",
                requestEntity,
                KakaoPayReadyResponse.class
        );

        // 5. 응답 처리
        KakaoPayReadyResponse response = responseEntity.getBody();

        // 6. TID 저장
        paymentMapper.updatePaymentStatus(payment.getId(), response.getTid());
        log.info("payREADY pay.getId : {}, pay.getTid : {}", payment.getId(), response.getTid());
        log.info("결제 준비 완료: {}", response);

        return response;
    }

    @Transactional
    public KakaoPayApprovalResponse approvePayment(Long paymentId, String pgToken) {
        // ready할 때 저장해놓은 TID로 승인 요청
        // Call “Execute approved payment” API by pg_token, TID mapping to the current payment transaction and other parameters.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY " + secretkey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // payment 조회
        Payment payment = paymentMapper.findPayment(paymentId);

        log.info("paymend.getUserCode() : {}", payment.getUserCode().toString());
        // Request param
        ApproveRequest approveRequest = ApproveRequest.builder()
                .cid(cid)
                .tid(payment.getTid())
                .partnerOrderId(payment.getId().toString())
                .partnerUserId(payment.getUserCode().toString())
                .pgToken(pgToken)
                .build();

        // Send Request
        HttpEntity<ApproveRequest> entityMap = new HttpEntity<>(approveRequest, headers);

        ResponseEntity<KakaoPayApprovalResponse> response = new RestTemplate().postForEntity(
                "https://open-api.kakaopay.com/online/v1/payment/approve",
                entityMap,
                KakaoPayApprovalResponse.class
        );

        // 승인 결과를 저장한다.
        // save the result of approval
        KakaoPayApprovalResponse res = response.getBody();
        if(res != null) {
            paymentMapper.updateTidAndPrice(payment.getId(), res.getTid(), res.getTotal());
        }else {
            throw new CustomException(ErrorCode.PAYMENT_HAS_NO_RESPONSE);
        }

        return res;
    }

}
