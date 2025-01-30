package com.knowit.SpringBootHealthCare.exceptions;

public class InvalidPatientDataException extends RuntimeException {
    public InvalidPatientDataException(String message) {
        super(message);
    }
}
