package com.example.demo.exception;

public class GeneralException extends RuntimeException {

    private String message;
    private String code;
    private String type;

    public GeneralException() {
    }

    public GeneralException(String message, Exception e) {
        super(message);
        this.message = message + e.getMessage();
    }


    public GeneralException(String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
