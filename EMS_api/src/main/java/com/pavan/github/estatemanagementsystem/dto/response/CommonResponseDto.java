package com.pavan.github.estatemanagementsystem.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class CommonResponseDto<T> {

    private String responseId;
    private String status;
    private String message;
    private T data;
    private Date timestamp;

}
