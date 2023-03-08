package com.kata.bankaccount.application.event.withdrawal;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.event.ApplicationEvent;


public class WithdrawalAccountEvent implements ApplicationEvent {
    private final AccountId accountId;

    public WithdrawalAccountEvent(AccountId accountId) {
        this.accountId = accountId;
    }
}
