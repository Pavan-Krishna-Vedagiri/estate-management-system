package com.pavan.github.estatemanagementsystem.dto;

import com.pavan.github.estatemanagementsystem.constants.enums.PaymentMethod;
import com.pavan.github.estatemanagementsystem.constants.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String paymentId;
    private String invoiceId;
    private String residentId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private PaymentMethod method;      // Cash, CreditCard, UPI, BankTransfer
    private PaymentStatus status;      // Completed, Pending
}
