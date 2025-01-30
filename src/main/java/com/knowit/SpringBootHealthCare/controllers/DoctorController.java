package com.knowit.SpringBootHealthCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.knowit.SpringBootHealthCare.entities.Doctor;
import com.knowit.SpringBootHealthCare.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService dservice;

    @Autowired
    public DoctorController(DoctorService dservice) {
	this.dservice = dservice;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
	return ResponseEntity.ok(dservice.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getOneDoctor(@PathVariable int id) {
	return ResponseEntity.ok(dservice.getOneDoctor(id));
    }

    @GetMapping("/filter/{exp}/{spec}")
    public ResponseEntity<List<Doctor>> getDoctors(@PathVariable int exp, @PathVariable String spec) {
	return ResponseEntity.ok(dservice.getDoctors(exp, spec));
    }

    @PostMapping("/save")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor d) {
	return new ResponseEntity<>(dservice.saveDoctor(d), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
	return ResponseEntity.ok(dservice.deleteDoctor(id));
    }
}
