package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room extends DateAttribute {

    @Id
    @Column(name = "room_id", length = 20, nullable = false)
    private String roomId;

    @Column(name = "property_id", length = 20, nullable = false)
    private String propertyId;

    @Column(name = "room_number", length = 50)
    private String roomNumber;

    @Column(name = "number_of_beds")
    private Integer numberOfBeds;

    @Column(name = "available_beds")   // spelling matches your SQL schema
    private Integer availableBeds;

    @Column(name = "sharing")
    private Integer sharing;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "floor", length = 50)
    private String floor;
}
