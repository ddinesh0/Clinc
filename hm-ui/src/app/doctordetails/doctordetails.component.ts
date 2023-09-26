import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';
import { MenuserviceService } from '../menuservice.service';
import { throwError } from 'rxjs';
import axios from 'axios';
import { AxiosService } from '../axios';

@Component({
  selector: 'app-doctordetails',
  templateUrl: './doctordetails.component.html',
  styleUrls: ['./doctordetails.component.css']
})
export class DoctordetailsComponent  implements OnInit{


binding: any;
Doctor: any;
isMenuOpen:boolean=true;




constructor(public doctorService:DoctorService,private router:Router,public menuService:MenuserviceService,
  private axiosservice:AxiosService){

}

  ngOnInit(): void {
    this.menuService.isMenuOpen$.subscribe(isOpen => {

      this.isMenuOpen = isOpen;
    });
    this.getview();


  }

  create() {
   this.router.navigate(['/doctor']);
    }

getview(){

  const apiUrl='http://localhost:8080/api/doctors/doctor';
  this.axiosservice.getData(apiUrl).subscribe(
    response=>{
      this.Doctor= response.data;
      console.log(this.Doctor);
    },(error)=>{
      console.log('An error occurred'+error);
      return throwError("something went worng");
    }
  )
}
  // this.doctorService.getview().subscribe((data:Doctor[])=>{

//   },

//   );
// }

    updatelist(id:number) {
        this.router.navigate(['doctorupdate/edit/'+id])
     }


    deleteRow(id:number) {

      this.doctorService.deletelist(id).subscribe(data=>{
        console.log(data),
        this.ngOnInit();
      },(error)=>{
        console.log('An error occurred'+error);
        return throwError("something went worng");
      });

    }

    back() {
      this.router.navigate(['admin'])

      }
}
