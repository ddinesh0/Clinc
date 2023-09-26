import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/appointment';
import { Patient } from '../patient';
import { Doctor } from '../doctor';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { DoctorService } from '../doctor.service';
import { PatientService } from '../patient.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit{

  appointment1:Appointment=new Appointment();
  admin:Admin=new Admin();
  doctor:Doctor=new Doctor();
  patient:Patient=new Patient();
 value:any;
 value1:any;
 value2:any;


 constructor(private router:Router,private adminService:AdminService, private doctorservice:DoctorService,
   private patientservice:PatientService,private authservice:AuthService) {
 }


public back(){
 this.router.navigate(['welcomepage']);
}
ngOnInit(): void {


}
adminLogin(){
 this.adminService.loginAdmin(this.admin).subscribe((data:any)=>{
this.value2=data;
console.log(this.value2)

  console.log("Registered Successfully"),
  this.router.navigate(['admin'])
  .then(()=>{
    window.location.reload();
   });
 });
 }

 public doctorLogin(){
   this.doctorservice.logindoctor(this.doctor).subscribe((data:any)=>{
    if(data){


     this.value1=data;
     console.log(this.value1)

     console.log("Doctor login sucessfully",this.value1.firstName);
     const myObjectString = JSON.stringify(this.value1);
     this.doctorservice.setprofile(myObjectString);

     this.router.navigate(['dashboard',{firstName:this.value1}])
     .then(()=>{
      window.location.reload();
     });
   }
   else{
    alert('Incorrect username and password');
   }
   });
 }


 patientlog() {
  this.patientservice.patientlogin(this.patient).subscribe(
    (data: any) => {
      if (data) {
        this.value = data;
        console.log(this.value);
        console.log("Patient login successfully", this.value.name);
        const myObjectString = JSON.stringify(this.value);
        this.patientservice.setprofile(myObjectString);
        this.router.navigate(['patientdash', { id: this.value }])
          .then(() => {
            window.location.reload();
          });
      } else {
        alert('Incorrect username or password');
      }
    },
    (error: any) => {
      console.log("Error logging in patient:", error);
      // alert('Incorrect emailId or Password');
      // Handle the error if necessary
    }
  );
   }

 public SignUp(){
  this.router.navigate(['/signup']);
 }
 public SignIn(){
  this.router.navigate(['/signin']);
 }
 public appointment(){

  this.router.navigate(['userlogin']);

 }
login(){
this.authservice.login();
}
logout(){
  this.authservice.logout();
}



}
