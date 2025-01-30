package com.knowit.SpringBootHealthCare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDoctorNotFoundException(DoctorNotFoundException ex) {
	Map<String, String> response = new HashMap<>();
	response.put("error", ex.getMessage());
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDoctorDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidDoctorDataException(InvalidDoctorDataException ex) {
	Map<String, String> response = new HashMap<>();
	response.put("error", ex.getMessage());
	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(PatientNotFoundException ex) {
	Map<String, String> response = new HashMap<>();
	response.put("error", ex.getMessage());
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPatientDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidPatientDataException(InvalidPatientDataException ex) {
	Map<String, String> response = new HashMap<>();
	response.put("error", ex.getMessage());
	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
	Map<String, String> response = new HashMap<>();
	response.put("error", "An unexpected error occurred: " + ex.getMessage());
	return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
