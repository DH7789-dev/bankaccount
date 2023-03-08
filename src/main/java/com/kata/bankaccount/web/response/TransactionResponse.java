package com.kata.bankaccount.web.response;

import com.kata.bankaccount.domain.enumerate.TransactionType;

public class TransactionResponse {
    public int id;
    public TransactionType transactionType;
    public String dateOfValidate;

    public TransactionResponse(int id, TransactionType transactionType, String dateOfValidate) {
        this.id = id;
        this.transactionType = transactionType;
        this.dateOfValidate = dateOfValidate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ",transaction='" + transactionType + '\'' +
                ",date='" + dateOfValidate + '\'' +
                '}';
    }
}
