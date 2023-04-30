package com.javastart.homework.utils;

import com.javastart.homework.entity.Account;
import com.javastart.homework.entity.Bill;
import com.javastart.homework.exceptions.NotDefaultBillException;

public class AccountUtils {
    public static Bill findDefaultBill(Account account) {
        return account.getBills().stream().
                filter(Bill::getDefault).
                findAny().orElseThrow(() -> new NotDefaultBillException("Unable to find default bill for account with id "
                        + account.getId()));
    }
}
