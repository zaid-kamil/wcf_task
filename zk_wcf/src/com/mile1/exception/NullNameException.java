package com.mile1.exception;

public class NullNameException extends Exception {
    public NullNameException() {
        super("name is null");
    }
}
