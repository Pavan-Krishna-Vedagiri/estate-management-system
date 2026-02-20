package com.pavan.github.estatemanagementsystem.entities;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth extends DateAttribute{

    private String userId;
    private String username;
    private String password;
    private String active;
    private String previousPassword;
    private boolean locked;
    
}
