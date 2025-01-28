package com.knowit.SpringBootHealthCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.SpringBootHealthCare.enitites.Doctor;
import com.knowit.SpringBootHealthCare.services.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {

    @Autowired
    DoctorService dservice;

    @GetMapping("/doctors/{exp}/{spec}")
    public List<Doctor> getDoctors(@PathVariable int exp, @PathVariable String spec) {
//	List<Doctor> doctors = dservice.getDoctors(exp, spec);
	return dservice.getDoctors(exp, spec);
    }

}
