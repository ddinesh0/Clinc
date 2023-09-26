import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/appointment';
import { AppointmentService } from 'src/app/appointment.service';
import { Patient } from 'src/app/patient';

@Component({
  selector: 'app-doctorpath',
  templateUrl: './doctorpath.component.html',
  styleUrls: ['./doctorpath.component.css']
})
export class DoctorpathComponent implements OnInit{
  patient:Patient=new Patient();

  appointment:Appointment=new Appointment();
  Appointment: any;

  constructor(public router:Router,public appointmentservice:AppointmentService){

  }


  ngOnInit(): void {
    this.getview();

  }
  getview(){
    this.appointmentservice.getview().subscribe((data:Appointment[])=>{
      this.Appointment=data;
      console.log(this.Appointment);
      const patient = this.Appointment[0].patient
      console.log(patient);

    });
  }
  closepopup() {
    this.router.navigate(['/dashboard'])

    }

}
