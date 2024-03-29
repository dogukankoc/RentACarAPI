package com.etiya.rentacar.core.exceptions.problemDetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails {

    public InternalServerErrorProblemDetails (){
        setTitle("Internal Server Error");
        setType("http://etiya.com/exceptions/internalserver");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
