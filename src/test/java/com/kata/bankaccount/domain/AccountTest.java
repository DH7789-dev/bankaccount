package com.kata.bankaccount.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class AccountTest {

    private AccountId accountId;
    private Account account;

    @BeforeEach
    public void setUp() {
        accountId = AccountId.of(123456);
        account = Account.of(accountId, 100);
    }

    @Test
    public void testGetId() {
        assertEquals(accountId, account.getId());
    }

    @Test
    public void testGetAmount() {
        assertEquals(100, account.getAmount());
    }


    @Test
    public void testNotEquals() {
        Account other = Account.of(AccountId.of(654321), 100);
        assertFalse(account.equals(other));
    }


}