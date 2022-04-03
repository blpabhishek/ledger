package com.example.commands;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String inputCommand) {
        super("Invalid command:" + inputCommand);
    }
}
