package com.ifmo.cs.kyoto.lab4.exceptions;

public class WrongValueException extends Exception{
    public WrongValueException(String ErrorMessage){
        super(ErrorMessage);
    }
}
