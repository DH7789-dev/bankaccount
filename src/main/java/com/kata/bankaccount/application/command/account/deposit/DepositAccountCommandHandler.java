package com.kata.bankaccount.application.command.account.deposit;


import com.kata.bankaccount.application.event.deposit.DepositAccountEvent;
import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.kernel.command.CommandHandler;
import com.kata.bankaccount.kernel.event.Event;
import com.kata.bankaccount.kernel.event.EventDispatcher;

public class DepositAccountCommandHandler implements CommandHandler<DepositAccount, AccountId> {
    private final AccountRepository accountRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public DepositAccountCommandHandler(AccountRepository accountRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.accountRepository = accountRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public AccountId handle(DepositAccount depositAccount) {
        final AccountId accountId = depositAccount.accountId;
        int actualAmount = accountRepository.findById(accountId).getAmount();
        int amountFinal = actualAmount + depositAccount.deposit;
        Account account = Account.of(accountId, amountFinal);
        accountRepository.save(account);
        eventEventDispatcher.dispatch(new DepositAccountEvent(accountId));
        return accountId;
    }

}