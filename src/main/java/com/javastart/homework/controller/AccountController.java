package com.javastart.homework.controller;

import com.javastart.homework.controller.dto.AccountRequestDTO;
import com.javastart.homework.controller.dto.AccountResponseDTO;
import com.javastart.homework.entity.Bill;
import com.javastart.homework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getById(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getById(id));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.save(accountRequestDTO.getName(), accountRequestDTO.getEmail(), accountRequestDTO.getBills().stream().
                map(billRequestDTO -> new Bill(billRequestDTO.getAmount(), billRequestDTO.getDefault())).
                collect(Collectors.toList()));
    }

}
