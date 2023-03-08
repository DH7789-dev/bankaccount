package com.kata.bankaccount.kernel.exeption;

import com.kata.bankaccount.domain.entities.AccountId;


public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withAccount(AccountId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withTransaction(AccountId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

}
