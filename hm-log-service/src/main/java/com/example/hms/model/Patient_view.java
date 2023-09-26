package com.example.hms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient_view")
public class Patient_view {
	@Id
	private int id;
		private String name;
		private String dob;
		private String contactno;
		private String gender;
		
		
		
		public Patient_view() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getContactno() {
			return contactno;
		}
		public void setContactno(String contactno) {
			this.contactno = contactno;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Patient_view [id=" + id + ", name=" + name + ", dob=" + dob + ", contactno=" + contactno
					+ ", gender=" + gender + "]";
		}
		
		
	

}
