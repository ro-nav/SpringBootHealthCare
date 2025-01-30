package com.knowit.SpringBootHealthCare.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pid;

    String fname;

    String lname;

    String address;

    String contact;

    @JsonIgnoreProperties("patients")
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    public Patient() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Patient(int pid, String fname, String lname, String address, String contact, Doctor doctor) {
	super();
	this.pid = pid;
	this.fname = fname;
	this.lname = lname;
	this.address = address;
	this.contact = contact;
	this.doctor = doctor;
    }

    public int getPid() {
	return pid;
    }

    public void setPid(int pid) {
	this.pid = pid;
    }

    public String getFname() {
	return fname;
    }

    public void setFname(String fname) {
	this.fname = fname;
    }

    public String getLname() {
	return lname;
    }

    public void setLname(String lname) {
	this.lname = lname;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getContact() {
	return contact;
    }

    public void setContact(String contact) {
	this.contact = contact;
    }

    public Doctor getDoctor() {
	return doctor;
    }

    public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
    }

}
