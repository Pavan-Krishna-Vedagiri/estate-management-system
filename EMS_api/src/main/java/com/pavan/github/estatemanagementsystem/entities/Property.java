package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "property")
public class Property extends DateAttribute{

    @Id
    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "name")
    private String name;

    @OneToOne
    private PropertyAddress propertyAddress;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @OneToMany
    private List<Room> rooms;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "description")
    private String description;

}
