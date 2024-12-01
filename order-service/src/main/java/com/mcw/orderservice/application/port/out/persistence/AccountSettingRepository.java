package com.mcw.orderservice.application.port.out.persistence;

import com.mcw.orderservice.model.account.AccountSetting;
import org.springframework.data.repository.CrudRepository;

public interface AccountSettingRepository extends CrudRepository<AccountSetting, Long> {
}
