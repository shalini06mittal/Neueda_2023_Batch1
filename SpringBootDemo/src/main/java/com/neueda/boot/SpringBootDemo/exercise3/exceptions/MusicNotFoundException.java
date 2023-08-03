package com.neueda.boot.SpringBootDemo.exercise3.exceptions;

public class MusicNotFoundException extends Exception{
    public MusicNotFoundException() {
        super();
    }

    public MusicNotFoundException(String message) {
        super(message);
    }

    public MusicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MusicNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
