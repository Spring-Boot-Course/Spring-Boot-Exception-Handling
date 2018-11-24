package me.sml.springexceptionhandling.exception;

public class DataIntegrityViolationException extends DataAccessException {
    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
