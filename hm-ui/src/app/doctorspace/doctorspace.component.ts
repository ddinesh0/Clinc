import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctorspace',
  templateUrl: './doctorspace.component.html',
  styleUrls: ['./doctorspace.component.css']
})
export class DoctorspaceComponent implements OnInit {

id:number=8;
  doctor:Doctor=new Doctor();
  shows=true;

  constructor(private router:Router,private route: ActivatedRoute, private doctorservice:DoctorService){

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log(params['id']);

      this.doctorservice.getdoctorById(params['id']).subscribe(data => {
        this.doctor = data;
      }, error => console.log(error));
    });

  }
Update() {

}
close(){
  this.router.navigate(['/dashboard'])
}


}
