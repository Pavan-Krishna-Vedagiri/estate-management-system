package com.pavan.github.estatemanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDto {

    private String addressId;
    private String doorNo;
    private String street;
    private String city;
    private String country;
    private String pincode;
}
