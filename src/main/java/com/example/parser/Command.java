package com.example.parser;

import com.example.domain.Ledger;
import com.example.domain.Status;
import com.example.domain.UnknownUserException;

public interface Command {
    Status execute(Ledger ledger) throws UnknownUserException;
    String getBank();
}
