import { Component, OnInit } from '@angular/core';
import { Patient } from '../../patient';
import { PatientService } from '../../patient.service';
import { Router } from '@angular/router';
import * as XLSX from 'xlsx';
import jspdf from "jspdf";
import html2canvas from "html2canvas"


@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patientlist.component.css']
})
export class PatientlistComponent implements OnInit {

  currentPage: number = 1;
Patient: any;
show=true;
page: number;
pageSize: number;
searchText:string='';


constructor(private patientservice:PatientService,private router:Router){}
  ngOnInit(): void {
    this.getview();

  }

  getview(){
    this.patientservice.getview().subscribe((data:Patient[])=>{
      this.Patient=data;
      console.log(this.Patient);
    });
  }
  closepopup() {
    this.router.navigate(['/dashboard'])

    }
    excel(){
      const worksheet: XLSX.WorkSheet = XLSX.utils.table_to_sheet(document.getElementById('PatientTable'));
      const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
      const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
      this.saveExcelFile(excelBuffer, 'Patientlist');
    }

    saveExcelFile(buffer: any, fileName: string) {
      const data: Blob = new Blob([buffer], { type: 'application/octet-stream' });
      const url: string = window.URL.createObjectURL(data);
      const link: HTMLAnchorElement = document.createElement('a');
      link.href = url;
      link.download = fileName + '.xlsx';
      link.click();
    }
    downloadpdf(){
      const data = document.getElementById("content");
      if (data instanceof HTMLElement) { // Perform a null check
        html2canvas(data).then(canvas => {
          console.log("downloading");

          var imgWidth = 206;
          var pageHeight = 250;
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

    OnsearchTextChanged(searchvalue:string){
      this.searchText = searchvalue;
      console.log(this.searchText);


    }


    matchesSearchText(patient: any): boolean {
      if (this.searchText === '') {
        return true;
      }
      const searchTextLower = this.searchText.toLowerCase();
      return patient.name.toLowerCase().includes(searchTextLower);

    }
}
