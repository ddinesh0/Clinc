import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../../patient.service';

@Component({
  selector: 'app-patientupdate',
  templateUrl: './patientupdate.component.html',
  styleUrls: ['./patientupdate.component.css']
})
export class PatientupdateComponent implements OnInit{

  constructor( private router:Router, private patientservice:PatientService ,public route:ActivatedRoute){

  }
ngOnInit(): void {

this.id=this.route.snapshot.params['id'];
console.log(this.id)
this.patientservice.getbypatientid(this.id).subscribe(data=>{
  this.patient=data;
},error=>console.log(error));

}
id:number
patient: any;

patientUpdate() {
  this.patientservice.updatepatient(this.id,this.patient).subscribe(data=>{
    this.getpatientlist();
     })
}
getpatientlist(){
  this.router.navigate(['patientview'])

}

}
