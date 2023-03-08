package com.kata.bankaccount.domain.entities;



import com.kata.bankaccount.kernel.Entity;

import java.util.Objects;

public final class Account implements Entity<AccountId> {

    private final AccountId accountId;
    private final int amount;

    private Account(AccountId accountId, int amount){
        this.accountId = Objects.requireNonNull(accountId);
        this.amount = Objects.requireNonNull(amount);
    }

    public static Account of(AccountId accountId, int amount){
        return new Account(accountId,amount);
    }


    @Override
    public AccountId getId() {
        return accountId;
    }

    public Integer getAmount() {
        return amount;
    }


}
