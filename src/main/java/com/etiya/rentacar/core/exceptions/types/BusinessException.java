package com.etiya.rentacar.core.exceptions.types;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message); //Base classtaki constroctur message'sine ulaştık super ile.
    }
}
