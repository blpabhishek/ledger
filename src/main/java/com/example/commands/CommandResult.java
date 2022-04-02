package com.example.commands;

import java.util.Objects;

public class CommandResult {
    private final String bank;
    private final String amountPaid;
    private final String noOfEMIsLeft;
    private final CommandType cmdType;

    public CommandResult(CommandType commandType, String bank, String amountPaid, String noOfEMIsLeft) {
        this.bank = bank;
        this.amountPaid = amountPaid;
        this.noOfEMIsLeft = noOfEMIsLeft;
        this.cmdType = commandType;
    }

    public boolean isBalanceCommand() {
        return cmdType == CommandType.BALANCE;
    }

    public String getBank() {
        return bank;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public String getNoOfEMIsLeft() {
        return noOfEMIsLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandResult commandResult = (CommandResult) o;
        return Objects.equals(amountPaid, commandResult.amountPaid) &&
                Objects.equals(noOfEMIsLeft, commandResult.noOfEMIsLeft) &&
                Objects.equals(bank, commandResult.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, amountPaid, noOfEMIsLeft);
    }

}
