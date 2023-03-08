package com.kata.bankaccount.domain.entities;




import com.kata.bankaccount.kernel.ValueObjectID;

import java.util.Objects;

public class TransactionId implements ValueObjectID {

    private final int value;

    private TransactionId(int valueId){this.value = valueId;}


    public static TransactionId of(int value){return new TransactionId(value);}

    public int getValue(){return value;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId that = (TransactionId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
