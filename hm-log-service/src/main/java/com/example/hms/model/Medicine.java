package com.example.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int medicineId;
private String medicineName;
private String medicineCompany;
private String medicineCompositon;
private int medicineCost;
private String discripttion;
private int medicineDose;
public int getMedicineId() {
	return medicineId;
}
public void setMedicineId(int medicineId) {
	this.medicineId = medicineId;
}
public String getMedicineName() {
	return medicineName;
}
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}
public String getMedicineCompany() {
	return medicineCompany;
}
public void setMedicineCompany(String medicineCompany) {
	this.medicineCompany = medicineCompany;
}
public String getMedicineCompositon() {
	return medicineCompositon;
}
public void setMedicineCompositon(String medicineCompositon) {
	this.medicineCompositon = medicineCompositon;
}
public int getMedicineCost() {
	return medicineCost;
}
public void setMedicineCost(int medicineCost) {
	this.medicineCost = medicineCost;
}
public String getDiscripttion() {
	return discripttion;
}
public void setDiscripttion(String discripttion) {
	this.discripttion = discripttion;
}
public int getMedicineDose() {
	return medicineDose;
}
public void setMedicineDose(int medicineDose) {
	this.medicineDose = medicineDose;
}

}
