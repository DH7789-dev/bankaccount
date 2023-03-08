package com.kata.bankaccount.application.command.account.withdrawal;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.command.Command;

public class WithdrawalAccount implements Command {
    public final AccountId accountId;
    public final int withdrawal;

    public WithdrawalAccount(AccountId accountId, int withdrawal) {
        this.accountId = accountId;
        this.withdrawal = withdrawal;
    }

}
