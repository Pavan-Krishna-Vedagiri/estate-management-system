package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.PaymentDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.Payment;
import com.pavan.github.estatemanagementsystem.repositories.PaymentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;
    private final ObjectMapper objectMapper;

    public PaymentService(PaymentRepo paymentRepo, ObjectMapper objectMapper) {
        this.paymentRepo = paymentRepo;
        this.objectMapper = objectMapper;
    }

    public CommonResponseDto<List<PaymentDto>> getAllPayment() {

        List<Payment> payments = paymentRepo.findAll();
        String responseMessage = "No Payments Found";
        List<PaymentDto> responseDtos = null;
        if (!payments.isEmpty()) {
           responseDtos = objectMapper.convertValue(payments, new TypeReference<List<PaymentDto>>() {});
           responseMessage = "Payments fetched successfully";
        }

        CommonResponseDto<List<PaymentDto>> response = CommonResponseDto.<List<PaymentDto>>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .data(responseDtos)
                .status(ResponseConstants.SUCCESS)
                .timestamp(new Date())
                .build();

        return response;
    }
}
