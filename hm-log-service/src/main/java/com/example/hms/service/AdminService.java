package com.example.hms.service;



import com.example.hms.model.Admin;

public interface AdminService {
public Admin saveAdmin(Admin admin) throws Exception;
public Admin loginAdmin(Admin admin);
public Admin findByAdminId(int adminId);
public Admin findByAdminEmailId(String adminEmailId);
Admin getById(int adminId);
}
