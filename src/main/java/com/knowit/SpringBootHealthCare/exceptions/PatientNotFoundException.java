package com.knowit.SpringBootHealthCare.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
	super(message);
    }
}
