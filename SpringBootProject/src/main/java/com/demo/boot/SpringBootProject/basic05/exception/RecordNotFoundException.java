package com.demo.boot.SpringBootProject.basic05.exception;

public class RecordNotFoundException extends  Exception{

    public RecordNotFoundException(String message) {
        super(message);
    }
}
