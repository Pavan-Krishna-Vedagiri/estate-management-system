package com.pavan.github.estatemanagementsystem.controllers;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import com.pavan.github.estatemanagementsystem.dto.PaymentDto;
import com.pavan.github.estatemanagementsystem.dto.response.CommonResponseDto;
import com.pavan.github.estatemanagementsystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.PAYMENT_URL)
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping()
    public CommonResponseDto<List<PaymentDto>> getAllPayments() {
        return paymentService.getAllPayment();
    }
}
