package com.kata.bankaccount.infrastructure.persistence;


import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.kernel.exeption.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class InMemoryAccount implements AccountRepository {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<AccountId, Account> dataAccount = new ConcurrentHashMap<>();


    @Override
    public AccountId nextIdentity() {
        return AccountId.of(count.incrementAndGet());
    }

    @Override
    public Account findById(AccountId id) {
        final Account account = dataAccount.get(id);
        if (account == null) {
            throw new NoSuchEntityException("No Account for " + id.getValue());
        }
        return account;
    }

    @Override
    public void delete(AccountId id) {
        dataAccount.remove(id);
    }

    @Override
    public void save(Account account) {
        dataAccount.put(account.getId(), account);
    }

    @Override
    public List<Account> findAll() {
        return dataAccount.values().stream().collect(Collectors.toList());
    }
}
