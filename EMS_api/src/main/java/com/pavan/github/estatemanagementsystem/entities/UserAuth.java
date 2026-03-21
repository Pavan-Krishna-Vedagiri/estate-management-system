package com.pavan.github.estatemanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_auth")
public class UserAuth extends DateAttribute{

    @Id
    private String userId;
    private String username;
    private String password;
    private String active;
    private String previousPassword;
    private boolean locked;
    
}
