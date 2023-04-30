package com.javastart.homework.service;

import com.javastart.homework.entity.Account;
import com.javastart.homework.entity.Bill;
import com.javastart.homework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    private final AccountService accountService;

    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object pay(Long accountId, BigDecimal amount) {

        Account account = accountService.getById(accountId);
        Bill bill = AccountUtils.findDefaultBill(account);
        bill.setAmount(bill.getAmount().subtract(amount));
        accountService.update(account);
        return "Success";
    }
}
