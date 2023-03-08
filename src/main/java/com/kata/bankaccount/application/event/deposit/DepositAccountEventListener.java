package com.kata.bankaccount.application.event.deposit;

import com.kata.bankaccount.kernel.event.EventListener;


public class DepositAccountEventListener implements EventListener<DepositAccountEvent> {

    @Override
    public void listenTo(DepositAccountEvent event) {
        System.out.println("listening DepositAccountEvent.");
    }
}
