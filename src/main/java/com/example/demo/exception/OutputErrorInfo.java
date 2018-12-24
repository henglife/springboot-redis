package com.example.demo.exception;

public class OutputErrorInfo {
    private String message;
    private String code;
    private String type;

    @Override
    public String toString() {
        return "OutputErrorInfo{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public OutputErrorInfo(String message, String code, String type) {
        this.message = message;
        this.code = code;
        this.type = type;
    }

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
