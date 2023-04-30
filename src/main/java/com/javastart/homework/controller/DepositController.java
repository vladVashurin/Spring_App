package com.javastart.homework.controller;

import com.javastart.homework.controller.dto.DepositDTO;
import com.javastart.homework.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
   @Autowired
    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
    @PostMapping("/deposit")
    public Object deposit(@RequestBody DepositDTO depositDTO){
return depositService.deposit(depositDTO.getAccountId(), depositDTO.getAmount());
    }
}
