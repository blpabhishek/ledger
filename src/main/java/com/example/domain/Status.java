package com.example.domain;

import java.util.Objects;

public class Status {
    private final long amountPaid;
    private final int noOfEMIsLeft;

    public Status(long amountPaid, int noOfEMIsLeft) {
        this.amountPaid = amountPaid;
        this.noOfEMIsLeft = noOfEMIsLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return amountPaid == status.amountPaid && noOfEMIsLeft == status.noOfEMIsLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountPaid, noOfEMIsLeft);
    }

    @Override
    public String toString() {
        return "Status{" +
                "amountPaid=" + amountPaid +
                ", noOfEMIsLeft=" + noOfEMIsLeft +
                '}';
    }
}
