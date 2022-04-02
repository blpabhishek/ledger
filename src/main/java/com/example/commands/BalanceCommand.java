package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;

import java.util.Objects;

public class BalanceCommand implements Command {
    private final String bank;
    private final String name;
    private final int term;

    public BalanceCommand(String bank, String name, int term) {
        this.bank = bank;
        this.name = name;
        this.term = term;
    }

    @Override
    public Status execute(Ledger ledger) throws UnknownUserException {
        return ledger.getBalance(name, term);
    }

    @Override
    public String getBank() {
        return bank;
    }

    public static BalanceCommand toBalanceCommand(String[] args) throws InvalidCommandException {
        try {
            return new BalanceCommand(args[1], args[2], Integer.parseInt(args[3]));
        } catch (Exception e) {
            throw new InvalidCommandException(String.join(" ", args));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceCommand that = (BalanceCommand) o;
        return term == that.term && Objects.equals(bank, that.bank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, name, term);
    }
}
