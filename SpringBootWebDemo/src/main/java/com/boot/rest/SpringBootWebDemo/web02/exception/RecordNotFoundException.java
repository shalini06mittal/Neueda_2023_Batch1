package com.boot.rest.SpringBootWebDemo.web02.exception;

public class RecordNotFoundException extends  Exception{

    public RecordNotFoundException(String message) {
        super(message);
    }
}
