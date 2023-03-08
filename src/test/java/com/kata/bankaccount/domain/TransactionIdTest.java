package com.kata.bankaccount.domain;

import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.entities.TransactionId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionIdTest {

    @Test
    public void testGetValue() {
        TransactionId transactionId = TransactionId.of(123456);
        assertEquals(123456, transactionId.getValue());
    }

    @Test
    public void testEquals() {
        TransactionId transactionIdd1 = TransactionId.of(123456);
        TransactionId transactionIdd2 = TransactionId.of(123456);
        assertTrue(transactionIdd1.equals(transactionIdd2));
    }

    @Test
    public void testNotEquals() {
        TransactionId transactionIdd1 = TransactionId.of(123456);
        TransactionId transactionIdd2 = TransactionId.of(654321);
        assertFalse(transactionIdd1.equals(transactionIdd2));
    }

    @Test
    public void testHashCode() {
        TransactionId transactionIdd1 = TransactionId.of(123456);
        TransactionId transactionIdd2 = TransactionId.of(123456);
        assertEquals(transactionIdd1.hashCode(), transactionIdd2.hashCode());
    }
}
