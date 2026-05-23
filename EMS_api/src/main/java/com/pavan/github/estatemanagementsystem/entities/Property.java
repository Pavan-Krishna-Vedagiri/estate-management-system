package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "property")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @Column(name = "property_id", length = 20)
    private String propertyId;

    @Column(name = "property_name", length = 100, nullable = false)
    private String propertyName;

    @Column(name = "description")
    private String description;

    @Column(name = "owner_name", length = 100)
    private String ownerName;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address_line1", length = 150)
    private String addressLine1;

    @Column(name = "address_line2", length = 150)
    private String addressLine2;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "pincode", length = 10)
    private String pincode;

    @Column(name = "total_rooms")
    private Integer totalRooms;

    @Column(name = "available_rooms")
    private Integer availableRooms;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_stamp")
    private Timestamp createdStamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_stamp")
    private Timestamp lastUpdatedStamp;
}