package com.knowit.SpringBootHealthCare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.knowit.SpringBootHealthCare.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "Select * from doctor where experience > :exp and specialization = :spec", nativeQuery = true)
    public List<Doctor> getDoctor(int exp, String spec);

}
