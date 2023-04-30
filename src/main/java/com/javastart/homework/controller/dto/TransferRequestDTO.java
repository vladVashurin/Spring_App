package com.javastart.homework.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransferRequestDTO {
    @JsonProperty("account_id_from")
    public Long accountIdFrom;
    @JsonProperty("account_id_to")
    public Long accountIdTo;
    @JsonProperty("amount")
    public BigDecimal amount;


}
