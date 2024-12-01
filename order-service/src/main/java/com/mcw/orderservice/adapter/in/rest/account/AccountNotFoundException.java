package com.mcw.orderservice.adapter.in.rest.account;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends Exception {

    private final Long accountId;
    public AccountNotFoundException(String s, Long accountId) {
        super(s);
        this.accountId = accountId;
    }
}
