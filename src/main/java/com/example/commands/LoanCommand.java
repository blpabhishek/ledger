package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.Loan;
import com.example.domain.UnknownUserException;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class LoanCommand implements Command {
    private final String bank;
    private final String name;
    private final int amount;
    private final int years;
    private final int terms;

    public LoanCommand(String bank, String name, int amount, int years, int terms) {
        this.bank = bank;
        this.name = name;
        this.amount = amount;
        this.years = years;
        this.terms = terms;
    }

    public CommandResult execute(Ledger ledger) throws UnknownUserException {
        Loan loan = new Loan(amount, years, terms);
        ledger.addLoan(name, loan);
        return new CommandResult(CommandType.LOAN);
    }

    @Override
    public String getBank() {
        return this.bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanCommand that = (LoanCommand) o;
        return amount == that.amount && years == that.years && terms == that.terms && Objects.equals(bank, that.bank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, name, amount, years, terms);
    }

    public static LoanCommand toLoanCommand(String[] args) throws InvalidCommandException {
        try {
            return new LoanCommand(args[1], args[2], parseInt(args[3]), parseInt(args[4]), parseInt(args[5]));
        } catch (Exception e) {
            throw new InvalidCommandException(String.join(" ", args));
        }
    }
}
