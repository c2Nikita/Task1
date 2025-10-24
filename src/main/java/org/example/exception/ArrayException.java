package org.example.exception;

public class ArrayException extends Exception {

    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(Throwable reason) {
        super(reason);
    }

    public ArrayException(Throwable reason, String message) {
        super(reason);
    }
}
