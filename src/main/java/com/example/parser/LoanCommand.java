package com.example.parser;

import com.example.domain.Ledger;
import com.example.domain.Loan;
import com.example.domain.Status;

import java.util.Objects;

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

    public Status execute(Ledger ledger) {
        Loan loan = new Loan(amount, years, terms);
        ledger.addLoan(name,loan);
        return ledger.getBalance(name,0);
    }

    @Override
    public String getBank() {
        return this.bank;
    }
}
