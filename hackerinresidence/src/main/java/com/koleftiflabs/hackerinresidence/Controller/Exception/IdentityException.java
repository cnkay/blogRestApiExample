package com.koleftiflabs.hackerinresidence.Controller.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IdentityException extends RuntimeException{
    private String message;
}
