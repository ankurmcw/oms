package com.mcw.orderservice.application.port.in.account;

import com.mcw.orderservice.model.account.Account;
import java.util.Optional;

public interface AccountUseCase {
    Account createAccount(Account account);

    Optional<Account> getAccount(Long id);
}
