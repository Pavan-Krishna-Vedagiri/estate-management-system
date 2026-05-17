package com.pavan.github.estatemanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResidentDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String guardianName;
    private String guardianEmail;
    private String guardianPhoneNumber;
    private String socialSecurityNumber;
    private String occupationName;
    private String companyName;
    private AddressDto address;
}
