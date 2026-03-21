package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAvailabilityId {

    private String propertyId;
    private String roomId;

}
