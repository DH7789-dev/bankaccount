package com.kata.bankaccount.application.query.transaction;

import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.domain.repository.TransactionRepository;
import com.kata.bankaccount.kernel.query.QueryHandler;


import java.util.List;

public class RetrieveTransactionHandler implements QueryHandler<RetrieveTransaction, List<Transaction>> {

    private final TransactionRepository transactionRepository;

    public RetrieveTransactionHandler(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> handle(RetrieveTransaction query) {
        return transactionRepository.findAll();
    }
}
