package com.mcw.orderservice.application.port.out.persistence;

import com.mcw.orderservice.model.account.Account;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByEmailAddress(String emailAddress);
}
