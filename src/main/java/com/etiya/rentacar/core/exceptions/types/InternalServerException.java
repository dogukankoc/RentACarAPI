package com.etiya.rentacar.core.exceptions.types;

import jdk.jshell.spi.ExecutionControl;

public class InternalServerException extends InternalError {

    public InternalServerException(String message){
        super(message);
    }
}
