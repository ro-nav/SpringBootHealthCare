package com.knowit.SpringBootHealthCare.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
	super(message);
    }
}
