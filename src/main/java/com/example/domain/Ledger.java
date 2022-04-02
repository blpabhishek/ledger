package com.example.domain;

import java.util.HashMap;
import java.util.Objects;

public class Ledger {
    private final HashMap<String, Loan> transactions = new HashMap<String, Loan>();
    private final String bank;

    public Ledger(String bank) {
        this.bank = bank;
    }

    public void addLoan(String name, Loan loan) {
        transactions.put(name, loan);
    }

    public int count() {
        return transactions.size();
    }

    public Status getBalance(String name, int terms) throws UnknownUserException{
        if(!transactions.containsKey(name))
            throw new UnknownUserException();
        Loan loan = transactions.get(name);
        return new Status(bank, loan.amountPaid(terms), loan.remainingEMI(terms));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
        return Objects.equals(transactions, ledger.transactions) && Objects.equals(bank, ledger.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, bank);
    }

    public boolean isSameBank(String bank) {
        return this.bank.equals(bank);
    }
}
