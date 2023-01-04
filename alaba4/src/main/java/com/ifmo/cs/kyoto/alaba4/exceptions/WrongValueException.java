package com.ifmo.cs.kyoto.alaba4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongValueException extends Exception{
    public WrongValueException(String ErrorMessage){
        super(ErrorMessage);
    }
}
