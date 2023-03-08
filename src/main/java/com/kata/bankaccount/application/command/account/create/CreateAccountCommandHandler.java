package com.kata.bankaccount.application.command.account.create;

import com.kata.bankaccount.application.event.create.CreateAccountEvent;
import com.kata.bankaccount.domain.entities.Account;
import com.kata.bankaccount.domain.entities.AccountId;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.kernel.command.CommandHandler;
import com.kata.bankaccount.kernel.event.Event;
import com.kata.bankaccount.kernel.event.EventDispatcher;


public class CreateAccountCommandHandler implements CommandHandler<CreateAccount, AccountId> {
    private final AccountRepository accountRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateAccountCommandHandler(AccountRepository accountRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.accountRepository = accountRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public AccountId handle(CreateAccount createAccount) {
        final AccountId accountId = accountRepository.nextIdentity();
        Account account = Account.of(accountId, createAccount.amount);
        accountRepository.save(account);
        eventEventDispatcher.dispatch(new CreateAccountEvent(accountId));
        return accountId;
    }

}
