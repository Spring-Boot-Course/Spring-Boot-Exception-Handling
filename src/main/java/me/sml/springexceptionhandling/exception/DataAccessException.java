package me.sml.springexceptionhandling.exception;

public class DataAccessException extends RuntimeException{

    public DataAccessException(String msg) {
        super(msg);
    }
}
