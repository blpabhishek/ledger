package com.example.domain;

import java.util.HashMap;
import java.util.Objects;

public class Ledger {
    private final HashMap<String, Loan> accounts = new HashMap<String, Loan>();
    private final String bank;

    public Ledger(String bank) {
        this.bank = bank;
    }

    public void addLoan(String name, Loan loan) {
        accounts.put(name, loan);
    }

    public int count() {
        return accounts.size();
    }

    public Status getBalance(String name, int terms) throws UnknownUserException {
        Loan loan = searchLoanAccount(name);
        return new Status(bank, loan.amountPaid(terms), loan.remainingEMI(terms));
    }

    public boolean isSameBank(String bank) {
        return this.bank.equals(bank);
    }

    public Status payment(String name, int lumSumAmount, int afterEmiTerms) throws UnknownUserException {
        Loan loan = searchLoanAccount(name);
        loan.addPayment(lumSumAmount, afterEmiTerms);
        return new Status(bank, loan.amountPaid(afterEmiTerms), loan.remainingEMI(afterEmiTerms));
    }

    private Loan searchLoanAccount(String name) throws UnknownUserException {
        if (!accounts.containsKey(name))
            throw new UnknownUserException();
        return accounts.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
        return Objects.equals(accounts, ledger.accounts) && Objects.equals(bank, ledger.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, bank);
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "accounts=" + accounts.keySet() +
                ", bank='" + bank + '\'' +
                '}';
    }
}
