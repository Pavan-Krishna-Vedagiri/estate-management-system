package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "room_availability")
@IdClass(RoomAvailabilityId.class)
public class RoomAvailability extends DateAttribute{

    @Id
    @Column(name = "room_id")
    private String roomId;

    @Id
    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "total_beds")
    private Integer totalBeds;

    @Column(name = "beds_booked")
    private Integer bedsBooked;

    @Column(name = "beds_available")
    private Integer bedsAvailable;

}
