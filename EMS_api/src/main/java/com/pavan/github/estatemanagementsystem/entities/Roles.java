package com.pavan.github.estatemanagementsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles extends DateAttribute{

    private String roleId;
    private String roleName;
    private String description;

}
