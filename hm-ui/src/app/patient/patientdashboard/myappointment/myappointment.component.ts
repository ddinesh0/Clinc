import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/patient.service';

@Component({
  selector: 'app-myappointment',
  templateUrl: './myappointment.component.html',
  styleUrls: ['./myappointment.component.css']
})
export class MyappointmentComponent implements OnInit {
  pat: any;
  value: any;

  constructor(private patientservice:PatientService,private router:Router){

  }

  ngOnInit(): void {
    this.pat=JSON.parse(this.patientservice.getprofile());
    this.value=this.pat;

     console.log(this.value);

  }

}
