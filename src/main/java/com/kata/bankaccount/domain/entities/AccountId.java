package com.kata.bankaccount.domain.entities;




import com.kata.bankaccount.kernel.ValueObjectID;

import java.util.Objects;

public class AccountId implements ValueObjectID {

    private final int value;

    private AccountId(int valueId){this.value = valueId;}


    public static AccountId of(int value){return new AccountId(value);}

    public int getValue(){return value;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId that = (AccountId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
