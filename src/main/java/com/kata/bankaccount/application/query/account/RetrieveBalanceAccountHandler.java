package com.kata.bankaccount.application.query.account;

import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.kernel.query.QueryHandler;


public class RetrieveBalanceAccountHandler implements QueryHandler<RetrieveBalanceAccount, Account> {

    private final AccountRepository accountRepository;

    public RetrieveBalanceAccountHandler(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account handle(RetrieveBalanceAccount query) {
        return accountRepository.findById(query.accountId);
    }
}
