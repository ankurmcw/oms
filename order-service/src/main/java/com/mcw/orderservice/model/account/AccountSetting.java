package com.mcw.orderservice.model.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_settings")
public class AccountSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_settings_generator")
    @SequenceGenerator(name = "account_settings_generator", sequenceName = "account_settings_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String settingName;

    @Column(name = "value", nullable = false)
    private String settingValue;

    @ManyToOne
    @JoinColumn(name ="account_id", nullable = false)
    private Account account;
}

