package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends DateAttribute {

    @Id
    @Column(name = "address_id")
    private String addressId;
    private String doorNo;
    private String street;
    private String city;
    private String country;
    private String pincode;

}