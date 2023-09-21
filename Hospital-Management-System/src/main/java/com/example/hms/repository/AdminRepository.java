package com.example.hms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
  Admin findByAdminEmailIdAndAdminPassword(String emialId,String password);


Admin findByAdminEmailId(String adminEmailId);




	
}
