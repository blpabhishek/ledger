package com.example.commands;

import com.example.domain.Balance;
import com.example.domain.Ledger;
import com.example.domain.UnknownUserException;

import java.util.Objects;

import static java.lang.String.valueOf;

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
    public CommandResult execute(Ledger ledger) throws UnknownUserException {
        Balance balance = ledger.accountBalance(name, term);
        String amount = valueOf(balance.amountPaid());
        String emiLeft = valueOf(balance.noOfEmisLeft());
        return new BalanceCommandResult(bank, amount, emiLeft);
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
