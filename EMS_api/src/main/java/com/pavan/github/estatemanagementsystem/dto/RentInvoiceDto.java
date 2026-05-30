package com.pavan.github.estatemanagementsystem.dto;

import com.pavan.github.estatemanagementsystem.constants.enums.RentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentInvoiceDto {

    private String invoiceId;
    private String bookingId;
    private String residentId;
    private BigDecimal rentAmount;
    private String monthYear;          // e.g. "2026-05"
    private LocalDate dueDate;
    private RentStatus status;         // DUE, PAID, PARTIAL
    private LocalDateTime createdStamp;
    private LocalDateTime lastUpdatedStamp;
}
