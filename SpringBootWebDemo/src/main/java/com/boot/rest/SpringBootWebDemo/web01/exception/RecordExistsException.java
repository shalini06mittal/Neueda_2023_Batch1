package com.boot.rest.SpringBootWebDemo.web01.exception;

public class RecordExistsException  extends  Exception{

    public RecordExistsException(String message) {
        super(message);
    }
}
