import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit{

  patient:Patient=new Patient();

appointment:Appointment=new Appointment();
  id: number;
  //appointid:number;



  constructor(public router:Router, public appointmentservice:AppointmentService,
    public patientService:PatientService,public route:ActivatedRoute){


  }



  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
console.log(this.id)
this.patientService.getbypatientid(this.id).subscribe(data=>{
  this.patient=data;
},error=>console.log(error));


  }

  createapp(){
  //  const data= {
  //     "id":2,
  //     "age":20,
  //     "dates":"20/05/2023",
  //     "disease":"fever",
  //     "patient":{
  //       "patientId":2
  //     }
  //   }
    this.appointmentservice.createapp(this.appointment,this.id,this.id).subscribe((data:any)=>{
      console.log(this.id)
      if(confirm("added sucessfull"))
      this.router.navigate(["appointmentlist"])
    })


  }



}
