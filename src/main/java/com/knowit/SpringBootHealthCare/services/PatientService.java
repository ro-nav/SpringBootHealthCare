package com.knowit.SpringBootHealthCare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootHealthCare.enitites.Patient;
import com.knowit.SpringBootHealthCare.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository prepo;

    public List<Patient> getAll() {
	return prepo.findAll();
    }

    public Patient getOne(int pid) {
	Optional<Patient> questionOpt = prepo.findById(pid);
	return questionOpt.orElseThrow(() -> new RuntimeException("Patient not found with ID: " + pid));
    }

    public Patient save(Patient p) {
	return prepo.save(p);
    }

    public String delete(int pid) {
	if (!prepo.existsById(pid)) {
	    throw new RuntimeException("Patient not found with ID: " + pid);
	}
	prepo.deleteById(pid);
	return "Patient deleted successfully.";
    }

}
