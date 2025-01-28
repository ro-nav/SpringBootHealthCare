package com.knowit.SpringBootHealthCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.SpringBootHealthCare.enitites.Doctor;
import com.knowit.SpringBootHealthCare.enitites.Patient;
import com.knowit.SpringBootHealthCare.enitites.PatientDummy;
import com.knowit.SpringBootHealthCare.services.DoctorService;
import com.knowit.SpringBootHealthCare.services.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

    @Autowired
    DoctorService dservice;

    @Autowired
    PatientService pservice;

    @GetMapping("/getPatient")
    public List<Patient> getAll() {
	return pservice.getAll();
    }

    @PostMapping("/savePatient")
    public Patient savePatient(@RequestBody PatientDummy pd) {
	Doctor doctor = pd.getDoctor();
	Doctor existingDoctor;

	try {
	    existingDoctor = dservice.getOne(doctor.getDoctor_id());
	} catch (RuntimeException e) {
	    // TODO: handle exception
	    existingDoctor = dservice.save(new Doctor(doctor.getDoctor_id(), doctor.getName(), doctor.getDegree(),
		    doctor.getSpecialization(), doctor.getExperience()));
	}

	Patient patient = new Patient();
	patient.setFname(pd.getFname());
	patient.setLname(pd.getLname());
	patient.setAddress(pd.getAddress());
	patient.setContact(pd.getContact());
	patient.setDoctor(existingDoctor);

	return pservice.save(patient);

    }

    @GetMapping("/deletepatient")
    public void deletePatient(@RequestParam int pid) {
	dservice.delete(pid);
    }

}
