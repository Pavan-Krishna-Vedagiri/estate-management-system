package com.pavan.github.estatemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class CommonResponseTO {

    private String requestId;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime respondedTime;
    private String responseCode;
    private String responseMessage;
    private String status;
    private String resourceId;
    private String resourceName;
}

