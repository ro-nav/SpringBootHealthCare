package com.knowit.SpringBootHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootHealthCare.entities.Patient;
import com.knowit.SpringBootHealthCare.exceptions.PatientNotFoundException;
import com.knowit.SpringBootHealthCare.exceptions.InvalidPatientDataException;
import com.knowit.SpringBootHealthCare.repositories.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository prepo;

    @Autowired
    public PatientService(PatientRepository prepo) {
	this.prepo = prepo;
    }

    public List<Patient> getAllPatients() {
	return prepo.findAll();
    }

    public Patient getOnePatient(int pid) {
	return prepo.findById(pid).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + pid));
    }

    public Patient savePatient(Patient p) {
	if (p.getFname() == null || p.getLname() == null || p.getDoctor() == null) {
	    throw new InvalidPatientDataException("Patient name and associated doctor cannot be null.");
	}
	return prepo.save(p);
    }

    public String deletePatient(int pid) {
	if (!prepo.existsById(pid)) {
	    throw new PatientNotFoundException("Patient not found with ID: " + pid);
	}
	prepo.deleteById(pid);
	return "Patient with ID " + pid + " has been deleted successfully.";
    }
}
