package com.example.parser;

public class InputParser {
    public LoanCommand parse(String string) {
        String[] strings = string.split(" ");
        return new LoanCommand(strings[1], strings[2], toInt(strings[3]), toInt(strings[4]), toInt(strings[5]));
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }
}
