package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Resident extends DateAttribute{

    @Id
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

}
