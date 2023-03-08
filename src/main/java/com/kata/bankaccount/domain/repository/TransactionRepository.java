package com.kata.bankaccount.domain.repository;

import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.domain.entities.TransactionId;
import com.kata.bankaccount.kernel.Repository;

public interface TransactionRepository extends Repository<TransactionId, Transaction> {
}
