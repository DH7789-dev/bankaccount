package com.kata.bankaccount.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.kata.bankaccount.domain.entities.AccountId;
import org.junit.jupiter.api.Test;

class AccountIdTest {

    @Test
    public void testGetValue() {
        AccountId accountId = AccountId.of(123456);
        assertEquals(123456, accountId.getValue());
    }

    @Test
    public void testEquals() {
        AccountId accountId1 = AccountId.of(123456);
        AccountId accountId2 = AccountId.of(123456);
        assertTrue(accountId1.equals(accountId2));
    }

    @Test
    public void testNotEquals() {
        AccountId accountId1 = AccountId.of(123456);
        AccountId accountId2 = AccountId.of(654321);
        assertFalse(accountId1.equals(accountId2));
    }

    @Test
    public void testHashCode() {
        AccountId accountId1 = AccountId.of(123456);
        AccountId accountId2 = AccountId.of(123456);
        assertEquals(accountId1.hashCode(), accountId2.hashCode());
    }

}

