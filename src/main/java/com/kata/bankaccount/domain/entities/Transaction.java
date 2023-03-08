package com.kata.bankaccount.domain.entities;

import com.kata.bankaccount.domain.enumerate.TransactionType;

import java.util.Objects;

public final class Transaction {

    private final TransactionId transactionId;
    private final TransactionType transactionType;
    private final String dateOfValidate;

    private Transaction(TransactionId transactionId, TransactionType transactionType, String dateOfValidate){
        this.transactionId = Objects.requireNonNull(transactionId);
        this.transactionType =  Objects.requireNonNull(transactionType);
        this.dateOfValidate = Objects.requireNonNull(dateOfValidate);
    }

    public static Transaction of(TransactionId transactionId, TransactionType transactionType,String dateOfValidate){
        return new Transaction(transactionId, transactionType, dateOfValidate);
    }

    public TransactionId getId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getDateOfValidate() {
        return dateOfValidate;
    }
}
