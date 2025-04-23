package com.baedal.payment.domain.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

public class KakaoApprove {

  @Getter
  @Builder
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Request {
    private String cid;  // 가맹점 코드
    private String tid;  // 결제 고유번호
    private String partnerOrderId;  // 가맹점 주문번호
    private String partnerUserId;  // 가맹점 회원 ID
    private String pgToken;  // 결제승인 요청 인증 토큰
  }

  @Getter
  @Builder
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Response {
    private String aid;  // 요청 고유 번호
    private String tid;  // 결제 고유 번호
    private String cid;  // 가맹점 코드
    private String sid;  // 정기 결제용 ID
    private String partnerOrderId;  // 가맹점 주문번호
    private String partnerUserId;  // 가맹점 회원 ID
    private String paymentMethodType;  // 결제 수단 (CARD 또는 MONEY)
    private Amount amount;  // 결제 금액 정보
    private CardInfo cardInfo;  // 결제 상세 정보 (카드 결제일 경우만 포함)
    private String itemName;  // 상품 이름
    private String itemCode;  // 상품 코드
    private Integer quantity;  // 상품 수량
    private String createdAt;  // 결제 준비 요청 시각
    private String approvedAt;  // 결제 승인 시각
    private String payload;  // 저장된 값
  }

  @Getter
  @Builder
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Amount {
    private Integer total;  // 전체 결제 금액
    private Integer taxFree;  // 비과세 금액
    private Integer vat;  // 부가세 금액
    private Integer point;  // 사용한 포인트 금액
    private Integer discount;  // 할인 금액
    private Integer greenDeposit;  // 컵 보증금
  }

  @Getter
  @Builder
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class CardInfo {
    private String cardNo;  // 카드 번호
    private String cardType;  // 카드 종류
    private String cardIssuer;  // 카드 발급사
    private String cardCompany;  // 카드 회사
  }

}
