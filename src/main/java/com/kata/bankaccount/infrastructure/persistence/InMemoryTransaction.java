package com.kata.bankaccount.infrastructure.persistence;

import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.domain.entities.TransactionId;
import com.kata.bankaccount.domain.repository.TransactionRepository;
import com.kata.bankaccount.kernel.exeption.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryTransaction implements TransactionRepository {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<TransactionId, Transaction> dataTransaction = new ConcurrentHashMap<>();


    @Override
    public TransactionId nextIdentity() {
        return TransactionId.of(count.incrementAndGet());
    }

    @Override
    public Transaction findById(TransactionId id) {
        final Transaction transaction = dataTransaction.get(id);
        if (transaction == null) {
            throw new NoSuchEntityException("No Account for " + id.getValue());
        }
        return transaction;
    }

    @Override
    public void delete(TransactionId id) {
        dataTransaction.remove(id);
    }

    @Override
    public void save(Transaction account) {
        dataTransaction.put(account.getId(), account);
    }

    @Override
    public List<Transaction> findAll() {
        return dataTransaction.values().stream().collect(Collectors.toList());
    }
}
