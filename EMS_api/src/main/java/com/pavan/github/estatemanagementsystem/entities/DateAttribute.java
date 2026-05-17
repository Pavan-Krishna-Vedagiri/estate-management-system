package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class DateAttribute {

    private Date createdStamp;
    private Date lastUpdatedStamp;

}
