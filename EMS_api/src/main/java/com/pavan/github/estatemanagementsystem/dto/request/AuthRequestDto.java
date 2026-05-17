package com.pavan.github.estatemanagementsystem.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
