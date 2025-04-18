package com.baedal.payment.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kakao-payment")
@Getter
@Setter
public class KakaoProperties {

  private String secretKeyDev;
  private String cid;
  private String approvalUrl;
  private String cancelUrl;
  private String failUrl;
}
