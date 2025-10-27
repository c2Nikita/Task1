package org.example.task.exception;

public class FileReaderException extends Exception {

    public FileReaderException() {
        super();
    }

    public FileReaderException(String message) {
        super(message);
    }

    public FileReaderException(Throwable reason) {
        super(reason);
    }

    public FileReaderException(Throwable reason,String message) {
        super(message, reason);
    }
}
