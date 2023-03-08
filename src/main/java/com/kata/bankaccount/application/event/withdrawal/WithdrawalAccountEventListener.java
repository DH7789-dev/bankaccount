package com.kata.bankaccount.application.event.withdrawal;

import com.kata.bankaccount.application.command.transaction.CreateTransaction;
import com.kata.bankaccount.domain.enumerate.TransactionType;
import com.kata.bankaccount.kernel.command.CommandBus;
import com.kata.bankaccount.kernel.event.EventListener;

import java.util.Date;

public class WithdrawalAccountEventListener implements EventListener<WithdrawalAccountEvent> {
    private CommandBus commandBus;
    @Override
    public void listenTo(WithdrawalAccountEvent event) {
        CreateTransaction createTransaction = new CreateTransaction(TransactionType.DEPOSIT,new Date().toString());
        commandBus.send(createTransaction);
        System.out.println("listening DepositAccountEvent.");
    }
}
