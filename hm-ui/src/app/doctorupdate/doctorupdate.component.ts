import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../doctor.service';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-doctorupdate',
  templateUrl: './doctorupdate.component.html',
  styleUrls: ['./doctorupdate.component.css']
})
export class DoctorupdateComponent implements OnInit {
doctor:Doctor=new Doctor();


  id!:number;

  constructor(private doctorService:DoctorService,private route:ActivatedRoute,
    public router:Router){

  }

ngOnInit(): void {
this.id=this.route.snapshot.params['id'];
console.log(this.id)
this.doctorService.getdoctorById(this.id).subscribe(data=>{
  this.doctor=data;
},error=>console.log(error));

}

profileupdate() {
 this.doctorService.updatedoctor(this.id,this.doctor).subscribe(data=>{
this.getdoctorlist();
 })

}

getdoctorlist(){
  this.router.navigate(['doctordetails'])
}




// ngOnInit(): void {
//   this.id=this.route.snapshot.params['id'];
//   this.BillService.getbillById(this.id).subscribe(data =>{
//     this.bill=data;
//   },error=> console.log(error));


// }
// onSubmit() {
//   this.BillService.updatelist(this.id,this.bill).subscribe(data => {

//   })
//   this.alert=true
//   this.onSubmit


}
