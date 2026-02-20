package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property extends DateAttribute{

    private String propertyId;
    private String name;
    private Address address;
    private int numberOfRooms;
    private List<Room> rooms;
    private String ownerId;
    private String description;

}
