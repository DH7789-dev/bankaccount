package com.kata.bankaccount.application.query.account;


import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.query.Query;

public class RetrieveBalanceAccount implements Query {
    public final AccountId accountId;

    public RetrieveBalanceAccount(AccountId accountId) {
        this.accountId = accountId;
    }
}
