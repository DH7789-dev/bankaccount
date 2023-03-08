package com.kata.bankaccount.application.event.create;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.event.ApplicationEvent;


public class CreateAccountEvent implements ApplicationEvent {
    private final AccountId accountId;

    public CreateAccountEvent(AccountId accountId) {
        this.accountId = accountId;
    }
}
