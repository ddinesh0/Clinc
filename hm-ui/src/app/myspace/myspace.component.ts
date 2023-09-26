import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuserviceService } from '../menuservice.service';

@Component({
  selector: 'app-myspace',
  templateUrl: './myspace.component.html',
  styleUrls: ['./myspace.component.css']
})
export class MyspaceComponent implements OnInit {


id:number
  admin:Admin=new Admin();
isMenuOpen: boolean=true;



constructor(public adminService:AdminService,public route:ActivatedRoute,
  public router:Router,public menuService:MenuserviceService){

}

ngOnInit(): void {

  this.menuService.isMenuOpen$.subscribe(isOpen => {

    this.isMenuOpen = isOpen;
  });

  this.route.paramMap.subscribe(paramMap => {
    const id = paramMap.get('id');
    console.log(id);

    this.adminService.getById(this.id).subscribe(
      data => {
        this.admin = data;
      },
      error => {
        console.log(error);
      }
    );
  });
}



  Update() {
    this.router.navigate(['/admin/adminupdate'])
    }
    Back() {
      this.router.navigate(['admin'])
      }

}
