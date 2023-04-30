package com.javastart.homework.controller;

import com.javastart.homework.controller.dto.PaymentRequestDTO;
import com.javastart.homework.controller.dto.TransferRequestDTO;
import com.javastart.homework.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/pay")
    public Object pay(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.pay(paymentRequestDTO.getAccountId(), paymentRequestDTO.getAmount());
    }
}
