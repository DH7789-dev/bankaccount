package com.kata.bankaccount.application.event.deposit;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.event.ApplicationEvent;


public class DepositAccountEvent implements ApplicationEvent {
    private final AccountId accountId;

    public DepositAccountEvent(AccountId accountId) {
        this.accountId = accountId;
    }
}
