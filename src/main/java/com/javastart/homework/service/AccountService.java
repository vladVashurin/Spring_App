package com.javastart.homework.service;

import com.javastart.homework.entity.Account;
import com.javastart.homework.entity.Bill;
import com.javastart.homework.exceptions.AccountNotFoundException;
import com.javastart.homework.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long save(String name, String email, List<Bill> bills) {
        return accountRepository.save(new Account(name, email, bills)).getId();
    }

    public Long save(Account account) {
        return accountRepository.save(account).getId();
    }

    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + id));
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }
}
