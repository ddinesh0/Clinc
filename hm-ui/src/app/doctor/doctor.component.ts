import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';
import { AdminService } from '../admin.service';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit{

doctor:Doctor=new Doctor();





  constructor(private router:Router, public adminService:AdminService ,public doctorService:DoctorService){

  }
  ngOnInit(): void {

  }
  createFrom() {




    }
    doctorprofile() {
      this.doctorService.formcreate(this.doctor).subscribe((data:any)=>{
        console.log("create profile"),
        this.router.navigate(['admin'])
      });

      }
      back() {
        this.router.navigate(['admin']);

      }
}
