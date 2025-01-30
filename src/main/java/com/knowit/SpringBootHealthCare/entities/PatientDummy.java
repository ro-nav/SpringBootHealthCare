package com.knowit.SpringBootHealthCare.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PatientDummy {

    String fname;

    String lname;

    String address;

    String contact;

    Doctor doctor;
}
