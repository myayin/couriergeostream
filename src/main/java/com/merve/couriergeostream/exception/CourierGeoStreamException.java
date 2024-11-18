package com.merve.couriergeostream.exception;

import lombok.Getter;

@Getter
public class CourierGeoStreamException extends Exception {

    private final String errorCode;

    public CourierGeoStreamException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}



