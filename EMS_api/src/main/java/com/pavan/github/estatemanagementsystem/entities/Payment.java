package com.pavan.github.estatemanagementsystem.entities;

import com.pavan.github.estatemanagementsystem.constants.enums.PaymentMethod;
import com.pavan.github.estatemanagementsystem.constants.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "resident_id")
    private String residentId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "method")
    private PaymentMethod method = PaymentMethod.Cash;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status = PaymentStatus.Completed;
}
