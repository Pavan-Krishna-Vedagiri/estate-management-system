package com.pavan.github.estatemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomBookingsDto {

    private String bookingId;
    private String propertyId;
    private String roomId;
    private String residentId;

    private Timestamp startDate;
    private Timestamp endDate;

    private String rentAmount;
    private String status;

}
