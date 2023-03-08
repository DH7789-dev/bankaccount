package com.kata.bankaccount.web.response;

import java.util.List;

public class TransactionsResponse {
    public final List<TransactionResponse> transactionsResponses;

    public TransactionsResponse(List<TransactionResponse> transactionResponses) {
        this.transactionsResponses = transactionResponses;
    }
}
