package com.pavan.github.estatemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomAvailabilityTo {

    private String roomId;
    private String propertyId;
    private Integer totalBeds;
    private Integer bedsBooked;
    private Integer bedsAvailable;

}
