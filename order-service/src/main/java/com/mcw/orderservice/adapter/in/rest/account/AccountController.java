package com.mcw.orderservice.adapter.in.rest.account;

import com.mcw.orderservice.application.port.in.account.AccountUseCase;
import com.mcw.orderservice.model.account.Account;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountUseCase accountUseCase;

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountWebModel addAccount(@Valid @RequestBody AccountWebModel request) {
        Account account = accountUseCase.createAccount(request.toDomain());
        return AccountWebModel.fromDomain(account);
    }

    @GetMapping("/account/{id}")
    public AccountWebModel getAccount(@PathVariable Long id) throws AccountNotFoundException {
        Optional<Account> account = accountUseCase.getAccount(id);
        if (account.isEmpty()) {
            throw new AccountNotFoundException("account not found", id);
        }
        return AccountWebModel.fromDomain(account.get());
    }
}
