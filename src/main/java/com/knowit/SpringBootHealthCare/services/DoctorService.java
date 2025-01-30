package com.knowit.SpringBootHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootHealthCare.entities.Doctor;
import com.knowit.SpringBootHealthCare.exceptions.DoctorNotFoundException;
import com.knowit.SpringBootHealthCare.exceptions.InvalidDoctorDataException;
import com.knowit.SpringBootHealthCare.repositories.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository drepo;

    @Autowired
    public DoctorService(DoctorRepository drepo) {
	this.drepo = drepo;
    }

    public List<Doctor> getAllDoctors() {
	return drepo.findAll();
    }

    public Doctor getOneDoctor(int doctor_id) {
	return drepo.findById(doctor_id)
		.orElseThrow(() -> new DoctorNotFoundException("Doctor not found with ID: " + doctor_id));
    }

    public List<Doctor> getDoctors(int exp, String spec) {
	List<Doctor> doctors = drepo.getDoctor(exp, spec);
	if (doctors.isEmpty()) {
	    throw new DoctorNotFoundException("No doctors found with " + exp + " years of experience in " + spec);
	}
	return doctors;
    }

    public Doctor saveDoctor(Doctor d) {
	if (d.getName() == null || d.getSpecialization() == null) {
	    throw new InvalidDoctorDataException("Doctor name and specialization cannot be null.");
	}
	return drepo.save(d);
    }

    public String deleteDoctor(int doctor_id) {
	if (!drepo.existsById(doctor_id)) {
	    throw new DoctorNotFoundException("Doctor not found with ID: " + doctor_id);
	}
	drepo.deleteById(doctor_id);
	return "Doctor with ID " + doctor_id + " has been deleted successfully.";
    }
}
