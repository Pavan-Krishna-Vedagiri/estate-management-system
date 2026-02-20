package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room extends DateAttribute{

    private String roomId;
    private String number;
    private Integer sharing;
    private String propertyId;
    private String description;

}
