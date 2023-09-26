import { Component, OnInit } from '@angular/core';
import { Patient } from '../../patient';
import { Router } from '@angular/router';
import { PatientService } from '../../patient.service';
import '@angular/localize/init';
import { MenuserviceService } from 'src/app/menuservice.service';






@Component({
  selector: 'app-patientview',
  templateUrl: './patientview.component.html',
  styleUrls: ['./patientview.component.css']
})
export class PatientviewComponent implements OnInit{

  // rowsPerPage: number;
  // currentPage = 1;
  // currentPageOrder: number = 0;

  page:number=1;
  pageSize:number=10;
  pageSizes:any[]=['3','4','5','6','7','8']
  collectionSize:any;
  Patient:Patient[];
  isMenuOpen:boolean=true;

searchText:string='';
patient: Patient=new Patient();
errorMessage:string;


constructor(private router:Router,private patientservice:PatientService,public menuService:MenuserviceService){

}

  ngOnInit(): void {

    this.menuService.isMenuOpen$.subscribe(isOpen => {

      this.isMenuOpen = isOpen;
    });
    this.getview();

  }


  // onPageChange(pageNumber: number): void {
  //   this.currentPage = pageNumber;
  // }

  // onPageChange1(event: any) {
  //   this.currentPageOrder = (event.currentPage - 1) * event.itemsPerPage;
  // }

  create() {
    this.router.navigate(['/patient'])

    }

    getview(){
      this.patientservice.getview().subscribe(data=>{
        this.Patient=data;
        this.collectionSize=this.Patient.length;
        console.log(this.collectionSize);

        console.log(this.Patient);
      },(err)=>{
        this.errorMessage= err.message;
      });
    }

    back() {

    }
    deleteRow(id:number) {
      this.patientservice.deletelist(id).subscribe(data=>{
        console.log(data),
        this.ngOnInit();
      });

    }
    updatelist(id:number) {
      this.router.navigate(['patientupdate/'+id])

    }

    appointment(id:number) {
      this.router.navigate(['appointment/'+id])

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
      // updatePagination() {
      //   this.currentPage = 1;
      // }
      getpage(e:any){
        this.pageSize=Number(e);
      }

public onPageChange(newPage: number): void {
  this.page = newPage;
}
}
