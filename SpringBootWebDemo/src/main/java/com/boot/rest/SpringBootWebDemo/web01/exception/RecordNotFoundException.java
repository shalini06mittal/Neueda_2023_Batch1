package com.boot.rest.SpringBootWebDemo.web01.exception;

public class RecordNotFoundException extends  Exception{

    public RecordNotFoundException(String message) {
        super(message);
    }
}
