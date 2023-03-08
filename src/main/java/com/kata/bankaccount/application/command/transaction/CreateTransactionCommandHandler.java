package com.kata.bankaccount.application.command.transaction;

import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.domain.entities.TransactionId;
import com.kata.bankaccount.domain.repository.TransactionRepository;
import com.kata.bankaccount.kernel.command.CommandHandler;



public class CreateTransactionCommandHandler implements CommandHandler<CreateTransaction, TransactionId> {
    private final TransactionRepository transactionRepository;

    public CreateTransactionCommandHandler(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionId handle(CreateTransaction createTransaction) {
        final TransactionId transactionId = transactionRepository.nextIdentity();
        Transaction transaction = Transaction.of(transactionId, createTransaction.transactionType,createTransaction.dateOfValidate);
        transactionRepository.save(transaction);
        return transactionId;
    }

}
