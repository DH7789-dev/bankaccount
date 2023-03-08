package com.kata.bankaccount.application.event.create;

import com.kata.bankaccount.application.command.transaction.CreateTransaction;
import com.kata.bankaccount.kernel.event.EventListener;

public class CreateAccountEventListener implements EventListener<CreateAccountEvent> {

    @Override
    public void listenTo(CreateAccountEvent event) {
        System.out.println("listening CreateAccountEvent.");

    }
}
