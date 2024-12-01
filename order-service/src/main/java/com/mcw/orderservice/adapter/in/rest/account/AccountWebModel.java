package com.mcw.orderservice.adapter.in.rest.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcw.orderservice.adapter.in.rest.common.validators.UniqueEmail;
import com.mcw.orderservice.model.account.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public record AccountWebModel(Long id,
                              @NotBlank(message = "name cannot be empty")
                              String name,
                              @NotBlank(message = "email cannot be empty")
                              @JsonProperty("email_address")
                              @UniqueEmail
                              @Email
                              String emailAddress) {

    public Account toDomain() {
        return Account.builder().name(this.name()).emailAddress(this.emailAddress()).build();
    }

    public static AccountWebModel fromDomain(Account account) {
        return new AccountWebModel(account.getId(), account.getName(), account.getEmailAddress());
    }
}
