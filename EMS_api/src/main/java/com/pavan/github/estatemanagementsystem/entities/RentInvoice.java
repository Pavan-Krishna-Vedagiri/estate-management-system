package com.pavan.github.estatemanagementsystem.entities;

import com.pavan.github.estatemanagementsystem.constants.enums.RentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rent_invoice")
public class RentInvoice {

    @Id
    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "resident_id")
    private String residentId;

    @Column(name = "rent_amount")
    private BigDecimal rentAmount;

    @Column(name = "month_year")
    private String monthYear; // e.g. "2026-05"

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private RentStatus status = RentStatus.DUE;

    @Column(name = "created_stamp")
    private LocalDateTime createdStamp;

    @Column(name = "last_updated_stamp")
    private LocalDateTime lastUpdatedStamp;
}

