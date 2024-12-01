package com.mcw.orderservice.adapter.in.rest.common.validators;

import com.mcw.orderservice.application.port.out.persistence.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final AccountRepository accountRepository;

    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(emailAddress)) return false;
        return accountRepository.findByEmailAddress(emailAddress).isEmpty();
    }
}
