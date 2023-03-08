package com.kata.bankaccount.infrastructure.persistence;

import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class InMemoryAccountTest {

    private AccountRepository accountRepository;

    @BeforeEach
    public void setup() {
        accountRepository = new InMemoryAccount();
    }

    @Test
    void testNextIdentity() {
        AccountId accountId1 = accountRepository.nextIdentity();
        AccountId accountId2 = accountRepository.nextIdentity();

        assertNotNull(accountId1);
        assertNotNull(accountId2);
        assertNotEquals(accountId1, accountId2);
    }

    @Test
    void testSaveAndFindById() {
        Account account = Account.of(AccountId.of(1),100);
        accountRepository.save(account);

        Account foundAccount = accountRepository.findById(account.getId());

        assertNotNull(foundAccount);
        assertEquals(account, foundAccount);
    }

    @Test
    void testFindAll() {
        Account account1 = Account.of(AccountId.of(1), 100);
        Account account2 = Account.of(AccountId.of(2),  200);
        accountRepository.save(account1);
        accountRepository.save(account2);

        List<Account> accounts = accountRepository.findAll();
        assertEquals(2, accounts.size());
        assertTrue(accounts.contains(account1));
        assertTrue(accounts.contains(account2));

    }

    @Test
    void deleteById() {
        Account account1 = Account.of(AccountId.of(1), 100);
        Account account2 = Account.of(AccountId.of(2),  200);
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.delete(account1.getId());
        List<Account> accounts = accountRepository.findAll();
        assertEquals(1, accounts.size());
    }
}
