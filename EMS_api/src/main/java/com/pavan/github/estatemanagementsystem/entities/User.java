package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends DateAttribute {
    private String userId;
    private String name;         
    private String email;        
    private String phoneNumber;
    private String password;
    private Address address;
    private List<String> rolesId;

}