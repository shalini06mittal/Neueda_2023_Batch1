package com.demo.boot.SpringBootProject.basic05.exception;

public class RecordExistsException  extends  Exception{

    public RecordExistsException(String message) {
        super(message);
    }
}
