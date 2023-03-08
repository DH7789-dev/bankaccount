package com.kata.bankaccount.domain;

import com.kata.bankaccount.domain.entities.Transaction;
import com.kata.bankaccount.domain.entities.TransactionId;
import com.kata.bankaccount.domain.enumerate.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransactionTest {

    @Test
    public void testTransactionCreation() {
        TransactionId transactionId = TransactionId.of(1);
        TransactionType transactionType = TransactionType.DEPOSIT;
        String dateOfValidate = "2023-03-08";
        Transaction transaction = Transaction.of(transactionId, transactionType, dateOfValidate);
        assertNotNull(transaction);
        assertEquals(transactionId, transaction.getId());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(dateOfValidate, transaction.getDateOfValidate());
    }

    @Test
    public void testTransactionCreationWithNullArgument() {
        TransactionId transactionId = TransactionId.of(1);
        TransactionType transactionType = TransactionType.DEPOSIT;
        String dateOfValidate = "2023-03-08";
        assertThrows(NullPointerException.class, () -> Transaction.of(null, transactionType, dateOfValidate));
        assertThrows(NullPointerException.class, () -> Transaction.of(transactionId, null, dateOfValidate));
        assertThrows(NullPointerException.class, () -> Transaction.of(transactionId, transactionType, null));
    }

    @Test
    public void testTransactionIdCreation() {
        int value = 1;
        TransactionId transactionId = TransactionId.of(value);
        assertNotNull(transactionId);
        assertEquals(value, transactionId.getValue());
    }

}