package com.example.parser;

import com.example.domain.Ledger;
import com.example.domain.Status;

public interface Command {
    Status execute(Ledger ledger);
    String getBank();
}
