import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdminComponent } from '../admin.component';
import { AdminService } from '../../admin.service';
import { Admin } from 'src/app/admin';

@Component({
  selector: 'app-adminupdate',
  templateUrl: './adminupdate.component.html',
  styleUrls: ['./adminupdate.component.css']
})
export class AdminupdateComponent implements OnInit{


  admin:Admin=new Admin();
  id: number;

constructor(private router:Router,public adminservice:AdminService,public route:ActivatedRoute){

}

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
console.log(this.id)
this.adminservice.getById(this.id).subscribe(data=>{
  this.admin=data;
},error=>console.log(error));
  }

  Update() {
    this.adminservice.updateadmin(this.id,this.admin).subscribe(data=>{
      this.getto;
    })
    }

  getto() {
    this.router.navigate(["myspace"])

    }

}
