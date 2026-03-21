package com.pavan.github.estatemanagementsystem.entities;

import com.pavan.github.estatemanagementsystem.constants.BookingType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "room_booking")
public class RoomBooking extends DateAttribute{

    @Id
    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "room_d")
    private String roomId;

    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "booked_on")
    private LocalDateTime bookedOn;

    @Column(name = "from_date")
    private LocalDateTime fromDate;

    @Column(name = "to_date")
    private LocalDateTime toDate;

    @Column(name = "booking_type")
    private BookingType bookingType;

}
