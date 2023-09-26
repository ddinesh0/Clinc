import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/appointment';
import { Router } from '@angular/router';
import { AppointmentService } from '../../appointment.service';
import { Patient } from '../../patient';

import { DatePipe } from '@angular/common';
import html2canvas from 'html2canvas';
import jspdf from 'jspdf';
import { MenuserviceService } from '../../menuservice.service';
@Component({
  selector: 'app-appointmentlist',
  templateUrl: './appointmentlist.component.html',
  styleUrls: ['./appointmentlist.component.css']
})
export class AppointmentlistComponent implements OnInit{

  currentPage:number=1;
  patient:Patient=new Patient();
appointment1:Appointment[];
appointment:Appointment=new Appointment();
Appointment: any;
jspdf:any;
then:any;
canvas:any;
fromdate: any;
todate: any;
myDate = new Date();
isMenuOpen:boolean=true;

constructor(public router:Router,public appointmentservice:AppointmentService,public menuService:MenuserviceService){

}
ngOnInit(): void {
  this.menuService.isMenuOpen$.subscribe(isOpen => {

    this.isMenuOpen = isOpen;
  });

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
  downloadPDF() {
  const data = document.getElementById("content");
if (data) {
html2canvas(data).then(canvas => {
console.log("downloding");


    var imgWidth = 208;
    var pageHeight = 295;
    var imgHeight = (canvas.height * imgWidth) / canvas.width;
    var heightLeft = imgHeight;

    const contentDataURL = canvas.toDataURL("image/png");
    let pdf = new jspdf("p", "mm", "a4");
    var position = 0;
    pdf.addImage(contentDataURL, "PNG", 0, position, imgWidth, imgHeight);
    pdf.save("appointment.pdf");
  });
}
}

changes() {
  if(this.fromdate!=null&&this.todate!=null)
  this.appointment1=this.appointment1.filter(
  m=> new Date(m.dates) >= new Date(this.fromdate )&& new Date(m.dates)<=new Date(this.todate)
  );
  console.log(this.appointment1)
  }


}


