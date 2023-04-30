package com.javastart.homework.service;

import com.javastart.homework.controller.dto.AccountResponseDTO;
import com.javastart.homework.entity.Account;
import com.javastart.homework.entity.Bill;
import com.javastart.homework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javastart.homework.exceptions.NotDefaultBillException;

import java.math.BigDecimal;

import static com.javastart.homework.utils.AccountUtils.findDefaultBill;

@Service
public class TransferService {

    @Autowired
    private final AccountService accountService;

    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }


    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        Account accountFrom = accountService.getById(accountIdFrom);
        Account accountTo = accountService.getById(accountIdTo);
        Bill billFrom = AccountUtils.findDefaultBill(accountFrom);
        Bill billTo = AccountUtils.findDefaultBill(accountTo);
        billFrom.setAmount(billFrom.getAmount().subtract(amount));
        billTo.setAmount(billTo.getAmount().add(amount));
        accountService.update(accountFrom);
        accountService.update(accountTo);
        return "Success";
    }
}
