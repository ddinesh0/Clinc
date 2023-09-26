package com.example.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
 public Doctor findByEmailAndPassword(String email,String password);

public Doctor findByEmail(String email);
}
