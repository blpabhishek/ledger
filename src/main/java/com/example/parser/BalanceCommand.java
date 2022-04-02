package com.example.parser;

import com.example.domain.Ledger;
import com.example.domain.Status;

import java.util.Objects;

public class BalanceCommand implements Command{
    private final String bank;
    private final String name;
    private final int term;

    public BalanceCommand(String bank, String name, int term) {
        this.bank = bank;
        this.name = name;
        this.term = term;
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

    @Override
    public Status execute(Ledger ledger) {
        return null;
    }

    @Override
    public String getBank() {
        return bank;
    }
}
