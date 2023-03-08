package com.kata.bankaccount.application.event.withdrawal;

import com.kata.bankaccount.kernel.event.EventListener;

import java.util.Date;

public class WithdrawalAccountEventListener implements EventListener<WithdrawalAccountEvent> {

    @Override
    public void listenTo(WithdrawalAccountEvent event) {
        System.out.println("listening WithdrawalAccountEvent.");
    }
}
