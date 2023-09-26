import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit{


  patient:Patient=new Patient();
  constructor(private router:Router,private patientService:PatientService){

  }
  public back(){
    this.router.navigate(['patientview']);
  }
  ngOnInit(): void {

  }

  patientRegister() {
    this.patientService.registerPatient(this.patient).subscribe((data:any)=>{
      console.log("Registered Successfully"),
      this.router.navigate(['admin'])
     });

  }

}
