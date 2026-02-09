package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;           
    private String name;         
    private String email;        
    private String phoneNumber;
    private String password;
    private Address address;

}