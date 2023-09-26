package com.example.hms.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.model.Admin;
import com.example.hms.model.Doctor;
import com.example.hms.service.AdminService;
import com.example.hms.service.DoctorService;

@RestController
@RequestMapping("/api/admin")
@ComponentScan(basePackages = "com.example.hms")
public class AdminController {
 @Autowired
 private AdminService adminService;
 

// @Autowired
// private DoctorService doctorService;
 
 @PostMapping("/register")
 public ResponseEntity<Admin>saveAdmin(@RequestBody Admin admin) throws Exception{
	 return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
 }
 @PostMapping("/login")
 public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin){
	 Admin ad=adminService.findByAdminEmailId(admin.getAdminEmailId());
	 if(ad.getAdminPassword().equals(admin.getAdminPassword()))
		 return ResponseEntity.ok(ad);
	 return new ResponseEntity<Admin>(adminService.loginAdmin(admin),HttpStatus.OK);
	
 }
 @GetMapping("/{id}")
 
	public ResponseEntity<Admin> getById(@PathVariable(value="id") int adminId){
		return new ResponseEntity<Admin>(adminService.getById(adminId),HttpStatus.OK);
	}
 
 
 
// @RequestMapping("/api/doctor")
// @PostMapping("/profile")
//	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
//		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
//	}
 
}
