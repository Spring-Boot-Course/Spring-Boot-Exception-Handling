package me.sml.springexceptionhandling.exception;

public class TestException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TestException(String message) {
        this.message = message;
    }
}
