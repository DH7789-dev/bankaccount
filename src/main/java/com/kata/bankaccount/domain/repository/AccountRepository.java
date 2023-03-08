package com.kata.bankaccount.domain.repository;

import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.kernel.Repository;



public interface AccountRepository extends Repository<AccountId, Account> {


}
