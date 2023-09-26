import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  admin:Admin=new Admin();
  constructor(private router:Router,private adminService:AdminService){

  }
  public back(){
    this.router.navigate(['welcomepage']);
  }
 ngOnInit(): void {

 }
 public adminRegister(){
 this.adminService.registerAdmin(this.admin).subscribe((data:any)=>{
  console.log("Registered Successfully"),
  this.router.navigate(['welcomepage'])
 });
 }

}
