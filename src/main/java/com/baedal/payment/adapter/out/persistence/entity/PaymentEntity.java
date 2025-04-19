package com.baedal.payment.adapter.out.persistence.entity;

import com.baedal.payment.adapter.out.persistence.enums.PaymentEntityMethod;
import com.baedal.payment.adapter.out.persistence.enums.PaymentEntityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "payments")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String tid;

  @Column(nullable = false)
  private Long orderId;

  @Column(nullable = false)
  private PaymentEntityMethod paymentMethod;

  @Column(nullable = false)
  private PaymentEntityStatus paymentStatus;

  @Column(nullable = false)
  private int totalAmount;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Builder
  public PaymentEntity(String tid, Long orderId, PaymentEntityMethod paymentMethod,
      PaymentEntityStatus paymentStatus, int totalAmount, LocalDateTime createdAt) {
    this.tid = tid;
    this.orderId = orderId;
    this.paymentMethod = paymentMethod;
    this.paymentStatus = paymentStatus;
    this.totalAmount = totalAmount;
    this.createdAt = createdAt;
  }
}
