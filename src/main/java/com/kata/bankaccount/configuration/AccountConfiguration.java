package com.kata.bankaccount.configuration;

import com.kata.bankaccount.application.command.account.create.CreateAccount;
import com.kata.bankaccount.application.command.account.create.CreateAccountCommandHandler;
import com.kata.bankaccount.application.command.account.deposit.DepositAccount;
import com.kata.bankaccount.application.command.account.deposit.DepositAccountCommandHandler;
import com.kata.bankaccount.application.command.account.withdrawal.WithdrawalAccount;
import com.kata.bankaccount.application.command.account.withdrawal.WithdrawalAccountCommandHandler;
import com.kata.bankaccount.application.command.transaction.CreateTransaction;
import com.kata.bankaccount.application.command.transaction.CreateTransactionCommandHandler;
import com.kata.bankaccount.application.event.create.CreateAccountEvent;
import com.kata.bankaccount.application.event.create.CreateAccountEventListener;
import com.kata.bankaccount.application.event.deposit.DepositAccountEvent;
import com.kata.bankaccount.application.event.deposit.DepositAccountEventListener;
import com.kata.bankaccount.application.event.withdrawal.WithdrawalAccountEvent;
import com.kata.bankaccount.application.event.withdrawal.WithdrawalAccountEventListener;
import com.kata.bankaccount.application.query.account.RetrieveBalanceAccount;
import com.kata.bankaccount.application.query.account.RetrieveBalanceAccountHandler;
import com.kata.bankaccount.application.query.transaction.RetrieveTransaction;
import com.kata.bankaccount.application.query.transaction.RetrieveTransactionHandler;
import com.kata.bankaccount.domain.repository.AccountRepository;
import com.kata.bankaccount.domain.repository.TransactionRepository;
import com.kata.bankaccount.infrastructure.event.DefaultEventDispatcher;
import com.kata.bankaccount.infrastructure.persistence.InMemoryAccount;
import com.kata.bankaccount.infrastructure.persistence.InMemoryTransaction;
import com.kata.bankaccount.kernel.command.Command;
import com.kata.bankaccount.kernel.command.CommandBus;
import com.kata.bankaccount.kernel.command.CommandHandler;
import com.kata.bankaccount.kernel.command.SimpleCommandBus;
import com.kata.bankaccount.kernel.event.Event;
import com.kata.bankaccount.kernel.event.EventDispatcher;
import com.kata.bankaccount.kernel.event.EventListener;
import com.kata.bankaccount.kernel.query.Query;
import com.kata.bankaccount.kernel.query.QueryBus;
import com.kata.bankaccount.kernel.query.QueryHandler;
import com.kata.bankaccount.kernel.query.SimpleQueryBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class AccountConfiguration {


    @Bean
    public AccountRepository AccountRepository() {
        return new InMemoryAccount();
    }

    @Bean
    public TransactionRepository TransactionRepository() {
        return new InMemoryTransaction();
    }


    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateAccountEvent.class, List.of(new CreateAccountEventListener()));
        listenerMap.put(DepositAccountEvent.class, List.of(new DepositAccountEventListener()));
        listenerMap.put(WithdrawalAccountEvent.class, List.of(new WithdrawalAccountEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }



    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateTransaction.class, new CreateTransactionCommandHandler(TransactionRepository()));
        commandHandlerMap.put(CreateAccount.class, new CreateAccountCommandHandler(AccountRepository(), eventEventDispatcher()));
        commandHandlerMap.put(DepositAccount.class, new DepositAccountCommandHandler(AccountRepository(), eventEventDispatcher()));
        commandHandlerMap.put(WithdrawalAccount.class, new WithdrawalAccountCommandHandler(AccountRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
                queryHandlerMap.put(RetrieveBalanceAccount.class, new RetrieveBalanceAccountHandler(AccountRepository()));
                queryHandlerMap.put(RetrieveTransaction.class, new RetrieveTransactionHandler(TransactionRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveBalanceAccountHandler retrieveBalanceAccountHandler() {
        return new RetrieveBalanceAccountHandler(AccountRepository());
    }

    @Bean
    public RetrieveTransactionHandler retrieveTransactionHandler() {
        return new RetrieveTransactionHandler(TransactionRepository());
    }

    @Bean
    public CreateAccountCommandHandler createAccountCommandHandler() {
        return new CreateAccountCommandHandler(AccountRepository(), eventEventDispatcher());
    }


    @Bean
    public DepositAccountCommandHandler createContractorCommandHandler() {
        return new DepositAccountCommandHandler(AccountRepository(), eventEventDispatcher());
    }


    @Bean
    public WithdrawalAccountCommandHandler withdrawalAccountsHandler() {
        return new WithdrawalAccountCommandHandler(AccountRepository(),eventEventDispatcher());
    }

    @Bean
    public CreateTransactionCommandHandler createTransactionCommandHandler() {
        return new CreateTransactionCommandHandler(TransactionRepository());
    }






}
