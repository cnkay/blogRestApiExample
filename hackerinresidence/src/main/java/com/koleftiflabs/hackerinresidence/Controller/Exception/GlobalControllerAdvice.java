package com.koleftiflabs.hackerinresidence.Controller.Exception;

import com.koleftiflabs.hackerinresidence.Controller.Exception.IdentityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalControllerAdvice extends Throwable{

    @ExceptionHandler(value = IdentityException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public void runtimeException409(IdentityException identityException){

    }
}
