import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit{

  admin:Admin=new Admin();
  doctor:Doctor=new Doctor();
  patient:Patient=new Patient();
value:any;
value1:any;



  constructor(private router:Router,private adminService:AdminService, private doctorservice:DoctorService,
    private patientservice:PatientService) {
  }


public back(){
  this.router.navigate(['welcomepage']);
}
ngOnInit(): void {


}
 adminLogin(){
  this.adminService.loginAdmin(this.admin).subscribe((data:any)=>{
   console.log("Registered Successfully"),
   this.router.navigate(['admin'])
  });
  }

  public doctorLogin(){
    this.doctorservice.logindoctor(this.doctor).subscribe((data:any)=>{
      this.value1=data;
      console.log(this.value1)

      console.log("Doctor login sucessfully",this.value1.firstName);
      const myObjectString = JSON.stringify(this.value1);
      this.doctorservice.setprofile(myObjectString);
      this.router.navigate(['dashboard',{firstName:this.value1}])
    });
  }

  patientlog() {
 this.patientservice.patientlogin(this.patient).subscribe((data:any)=>{
   this.value = data;
  console.log(this.value);

  console.log("patient login sucessfully",this.value.name );
  const myObjectString = JSON.stringify(this.value);
  this.patientservice.setprofile(myObjectString);

  this.router.navigate(['patientdash',{id:this.value}])
 },
 (error: any) => {
  console.log("Error logging in patient:", error);
  // Handle the error if necessary
});
    }


    // public patientLogin(id: number) {
    //   const patient = this.patientservice.getbypatientid(id);

    //   if (patient) {
    //     this.patientservice.registerPatient(this.patient).subscribe((data: any) => {
    //       console.log("Patient login successful");
    //       this.router.navigate(['patientdash']);
    //     });
    //   } else {
    //     console.log("Patient not found");

    //   }
    // }




  }





