package com.pavan.github.estatemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private String roomId;
    private String propertyId;
    private String roomNumber;
    private Integer numberOfBeds;
    private Integer availableBeds;
    private Integer sharing;
    private String description;
    private String floor;
}
