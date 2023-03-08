package com.kata.bankaccount.application.command.account.deposit;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.command.Command;

public class DepositAccount implements Command {

    public final AccountId accountId;
    public final int deposit;

    public DepositAccount(AccountId accountId, int deposit) {
        this.accountId = accountId;
        this.deposit = deposit;
    }
}
