package com.plantnursery.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPlantException extends Exception {

    public InvalidPlantException(String message) {
        super(message);
        System.out.println("Hi");
    }
}
