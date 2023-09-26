import { Component, Input, OnInit } from '@angular/core';
import { DoctorService } from '../../../doctor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/doctor';
import jspdf from "jspdf";
import html2canvas from "html2canvas";
// import { faFacebookSquare } from '@fortawesome/free-brands-svg-icons/faFacebookSquare';
// import { faTwitterSquare } from '@fortawesome/free-brands-svg-icons/faTwitterSquare';
// import { faPinterest } from '@fortawesome/free-brands-svg-icons/faPinterest';

@Component({
  selector: 'app-docpofile',
  templateUrl: './docpofile.component.html',
  styleUrls: ['./docpofile.component.css']
})
export class DocpofileComponent implements OnInit{



  id:number;
shows=true;

doctor:Doctor=new Doctor();
Doctor: any;



constructor(private doctorser:DoctorService,private router:Router,private route:ActivatedRoute){}

ngOnInit(): void {

  this.doctorser.getview().subscribe((data:Doctor[])=>{
    this.Doctor=data;
    console.log(this.Doctor);
  });

}
handleClick() {
  this.router.navigate(['/patientdash'])

}
downloadPDF() {
  const data = document.getElementById("content");
  if (data instanceof HTMLElement) { // Perform a null check
    html2canvas(data).then(canvas => {
      console.log("downloading");

      var imgWidth = 210;
      var pageHeight = 260;
      var imgHeight = (canvas.height * imgWidth) / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL("image/png");
      let pdf = new jspdf("p", "mm", "a4");
      var position = 0;
      pdf.addImage(contentDataURL, "PNG", 0, position, imgWidth, imgHeight);
      pdf.save("Doctorprofile.pdf");
    });
  }
}



}

