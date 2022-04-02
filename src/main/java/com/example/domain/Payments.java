package com.example.domain;

import java.util.ArrayList;

public class Payments extends ArrayList<Payment> {

    public long paymentsAfter(int terms) {
        return this.stream()
                .filter((p) -> p.greaterThan(terms))
                .mapToLong(Payment::amount)
                .sum();
    }
}
