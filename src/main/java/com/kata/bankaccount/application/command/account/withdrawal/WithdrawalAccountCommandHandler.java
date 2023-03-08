package com.kata.bankaccount.application.command.account.withdrawal;

import com.kata.bankaccount.application.command.account.deposit.DepositAccount;
import com.kata.bankaccount.application.event.deposit.DepositAccountEvent;
import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.kernel.command.CommandHandler;
import com.kata.bankaccount.kernel.event.Event;
import com.kata.bankaccount.kernel.event.EventDispatcher;

public class WithdrawalAccountCommandHandler implements CommandHandler<WithdrawalAccount, AccountId> {
    private final AccountRepository accountRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public WithdrawalAccountCommandHandler(AccountRepository accountRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.accountRepository = accountRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public AccountId handle(WithdrawalAccount withdrawalAccount) {
        final AccountId accountId = withdrawalAccount.accountId;
        int actualAmount = accountRepository.findById(accountId).getAmount();
        int amountFinal = actualAmount - withdrawalAccount.withdrawal;
        Account account = Account.of(accountId, amountFinal);
        accountRepository.save(account);
        eventEventDispatcher.dispatch(new DepositAccountEvent(accountId));
        return accountId;
    }

}