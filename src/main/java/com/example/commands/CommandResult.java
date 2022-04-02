package com.example.commands;

import java.util.Objects;

public class CommandResult {
    private final String bank;
    private final long amountPaid;
    private final int noOfEMIsLeft;

    public CommandResult(String bank, long amountPaid, int noOfEMIsLeft) {
        this.bank = bank;
        this.amountPaid = amountPaid;
        this.noOfEMIsLeft = noOfEMIsLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandResult commandResult = (CommandResult) o;
        return amountPaid == commandResult.amountPaid && noOfEMIsLeft == commandResult.noOfEMIsLeft && Objects.equals(bank, commandResult.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, amountPaid, noOfEMIsLeft);
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "bank='" + bank + '\'' +
                ", amountPaid=" + amountPaid +
                ", noOfEMIsLeft=" + noOfEMIsLeft +
                '}';
    }
}
