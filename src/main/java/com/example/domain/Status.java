package com.example.domain;

import java.util.Objects;

public class Status {
    private final String bank;
    private final long amountPaid;
    private final int noOfEMIsLeft;

    public Status(String bank, long amountPaid, int noOfEMIsLeft) {
        this.bank = bank;
        this.amountPaid = amountPaid;
        this.noOfEMIsLeft = noOfEMIsLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return amountPaid == status.amountPaid && noOfEMIsLeft == status.noOfEMIsLeft && Objects.equals(bank, status.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, amountPaid, noOfEMIsLeft);
    }

    @Override
    public String toString() {
        return "Status{" +
                "bank='" + bank + '\'' +
                ", amountPaid=" + amountPaid +
                ", noOfEMIsLeft=" + noOfEMIsLeft +
                '}';
    }
}
