package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SequenceItem extends DateAttribute{

    @Id
    private String sequenceId;
    private String sequenceNumber ;

}
