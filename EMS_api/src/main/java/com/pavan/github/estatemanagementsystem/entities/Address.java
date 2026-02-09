package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String id;         // Primary key
    private String doorNo;     // Not null
    private String street;     // Not null
    private String city;       // Not null
    private String country;    // Optional
    private String pincode;     // Optional

}