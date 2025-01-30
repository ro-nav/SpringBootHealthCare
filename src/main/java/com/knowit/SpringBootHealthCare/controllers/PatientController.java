package com.knowit.SpringBootHealthCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knowit.SpringBootHealthCare.entities.Doctor;
import com.knowit.SpringBootHealthCare.entities.Patient;
import com.knowit.SpringBootHealthCare.entities.PatientDummy;
import com.knowit.SpringBootHealthCare.exceptions.InvalidPatientDataException;
import com.knowit.SpringBootHealthCare.services.DoctorService;
import com.knowit.SpringBootHealthCare.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final DoctorService dservice;
    private final PatientService pservice;

    @Autowired
    public PatientController(DoctorService dservice, PatientService pservice) {
	this.dservice = dservice;
	this.pservice = pservice;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getAllPatients() {
	return ResponseEntity.ok(pservice.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getOnePatient(@PathVariable int id) {
	return ResponseEntity.ok(pservice.getOnePatient(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody PatientDummy pd) {
	Doctor doctor = pd.getDoctor();
	Doctor existingDoctor;

	try {
	    existingDoctor = dservice.getOneDoctor(doctor.getDoctor_id());
	} catch (RuntimeException e) {
	    existingDoctor = dservice.saveDoctor(new Doctor(doctor.getDoctor_id(), doctor.getName(), doctor.getDegree(),
		    doctor.getSpecialization(), doctor.getExperience()));
	}

	if (pd.getFname() == null || pd.getLname() == null) {
	    throw new InvalidPatientDataException("First name and last name cannot be null.");
	}

	Patient patient = new Patient();
	patient.setFname(pd.getFname());
	patient.setLname(pd.getLname());
	patient.setAddress(pd.getAddress());
	patient.setContact(pd.getContact());
	patient.setDoctor(existingDoctor);

	return new ResponseEntity<>(pservice.savePatient(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
	return ResponseEntity.ok(pservice.deletePatient(id));
    }
}
