package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_bookings")
public class RoomBookings extends DateAttribute{

    @Id
    private String bookingId;

    private String propertyId;
    private String roomId;
    private String residentId;

    private Timestamp startDate;
    private Timestamp endDate;

    private String rentAmount;
    private String status;
}

