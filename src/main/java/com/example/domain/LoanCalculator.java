package com.example.domain;

public class LoanCalculator {
    private final double amount;
    private final int year;
    private final float rate;

    public LoanCalculator(double amount, int year, float rate) {
        this.amount = amount;
        this.year = year;
        this.rate = rate;
    }

    public long totalAmount() {
        return round(amount + interest());
    }

    public long monthlyEMI() {
        return round(totalAmount() / timeInMonths());
    }

    public long remainingAmount(int terms) {
        return totalAmount() - amountPaid(terms);
    }

    public long amountPaid(int terms) {
        return(terms * monthlyEMI());
    }

    public int remainingEMI(int terms) {
        return (int) timeInMonths() - terms;
    }

    private long round(double i) {
        return (long) Math.ceil(i);
    }

    private double interest() {
        return (amount * year * rate) / 100;
    }

    private float timeInMonths() {
        return year * 12;
    }
}
