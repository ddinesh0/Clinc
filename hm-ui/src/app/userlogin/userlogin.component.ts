import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit{
  patient:Patient=new Patient();

constructor(private router:Router,public patientservice:PatientService){

}





  ngOnInit(): void {




  }


  patientRegister() {

    this.patientservice.registerPatient(this.patient).subscribe((data:any)=>{

      console.log("Registered Successfully")
      if(confirm("Registered Successfully"))
      this.router.navigate(['welcomepage'])


     });

  }
  back() {
    this.router.navigate(['welcomepage'])

  }

}
