package com.pavan.github.estatemanagementsystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.github.estatemanagementsystem.constants.ResponseConstants;
import com.pavan.github.estatemanagementsystem.dto.RentInvoiceDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.entities.RentInvoice;
import com.pavan.github.estatemanagementsystem.repositories.RentInvoiceRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RentInvoiceService {

    private final RentInvoiceRepo rentInvoiceRepo;
    private final ObjectMapper objectMapper;

    public RentInvoiceService(RentInvoiceRepo rentInvoiceRepo, ObjectMapper objectMapper) {
        this.rentInvoiceRepo = rentInvoiceRepo;
        this.objectMapper = objectMapper;
    }

    public CommonResponseDto<List<RentInvoiceDto>> getAllRentInvoices() {
        List<RentInvoice> rentInvoices = rentInvoiceRepo.findAll();
        List<RentInvoiceDto> responseDto = null;
        String responseMessage = "No rentInvoices found";
        if (!rentInvoices.isEmpty()) {
            responseDto = objectMapper.convertValue(rentInvoices, new TypeReference<List<RentInvoiceDto>>() {
            });
            responseMessage = "RentInvoices fetched successfully";
        }

        CommonResponseDto<List<RentInvoiceDto>> response = CommonResponseDto.<List<RentInvoiceDto>>builder()
                .responseId(UUID.randomUUID().toString())
                .message(responseMessage)
                .status(ResponseConstants.SUCCESS)
                .data(responseDto)
                .timestamp(new Date())
                .build();

        return response;
    }
}
