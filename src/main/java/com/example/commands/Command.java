package com.example.commands;

import com.example.domain.Ledger;
import com.example.domain.UnknownUserException;

public interface Command {
    CommandResult execute(Ledger ledger) throws UnknownUserException;
    String getBank();
}
