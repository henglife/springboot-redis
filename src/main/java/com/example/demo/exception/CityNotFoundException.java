package com.example.demo.exception;

public class CityNotFoundException extends GeneralException {

    public CityNotFoundException() {
    }

    public CityNotFoundException(String message) {
        super(message);
    }
}
