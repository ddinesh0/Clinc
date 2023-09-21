package com.example.hms.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hms.model.Admin;
import com.example.hms.model.Doctor;
import com.example.hms.repository.AdminRepository;
import com.example.hms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) throws Exception {
		if(admin!=null) 
		{
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			String enPassWrd=bcrypt.encode(admin.getAdminPassword());
			admin.setAdminPassword(enPassWrd);
			return adminRepository.save(admin);
		}
		else {
			 throw new Exception("User Already Exists");
		}
		
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		return adminRepository.findByAdminEmailIdAndAdminPassword(admin.getAdminEmailId(),admin.getAdminPassword());
	}



	@Override
	public Admin findByAdminEmailId(String adminEmailId) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminEmailId(adminEmailId);
	}

	@Override
	public Admin getById(int adminId) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).get();
	}

	@Override
	public Admin findByAdminId(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
	
}
