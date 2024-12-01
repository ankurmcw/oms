package com.mcw.orderservice.application.service.account;

import com.mcw.orderservice.application.port.in.account.AccountUseCase;
import com.mcw.orderservice.application.port.out.persistence.AccountRepository;
import com.mcw.orderservice.model.account.Account;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountUseCase {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccount(Long id) {
        if (Objects.isNull(id)) return Optional.empty();
        return accountRepository.findById(id);
    }
}
