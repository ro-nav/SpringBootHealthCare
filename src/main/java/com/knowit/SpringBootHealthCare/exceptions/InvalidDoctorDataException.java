package com.knowit.SpringBootHealthCare.exceptions;

public class InvalidDoctorDataException extends RuntimeException {
    public InvalidDoctorDataException(String message) {
	super(message);
    }
}
