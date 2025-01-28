package com.knowit.SpringBootHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootHealthCare.enitites.Doctor;
import com.knowit.SpringBootHealthCare.repositories.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository drepo;

    public List<Doctor> getDoctors(int exp, String spec) {
	return drepo.getDoctor(exp, spec);
    }

    public Doctor getOne(int doctor_id) {
	return drepo.findById(doctor_id)
		.orElseThrow(() -> new RuntimeException("Topic not found with ID: " + doctor_id));
    }

    public Doctor save(Doctor d) {
	return drepo.save(d);
    }

    public String delete(int doctor_id) {
	if (!drepo.existsById(doctor_id)) {
	    throw new RuntimeException("Doctor not found with ID: " + doctor_id);
	}
	drepo.deleteById(doctor_id);
	return "Doctor and associated patients deleted successfully.";
    }

}
