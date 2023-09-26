import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NavsideService } from '../navside.service';
import { NavserviceService } from '../navservice.service';
import { MenuserviceService } from '../menuservice.service';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{
toggleDropdown() {
  this.isDropdownOpen = !this.isDropdownOpen;
}
  collapses: boolean=true;
sticky: any;
position: any;
isMenuOpen: boolean=false;
checkSidebar:boolean=true;
isScrolled=false;
Patient: any;
isDropdownOpen: boolean=false;

  constructor(public router:Router, public navService:NavserviceService,public menuService:MenuserviceService ,
    public patientservice:PatientService){

  }
  @ViewChild('blueheader') blueheader!: ElementRef<HTMLElement>;
ngOnInit(): void {
  this.onWindowScroll();


}

collopse(){
  this.collapses=!this.collapses
  console.log(this.collapses);
}
  collapseSidebar() {
    this.navService.collapseSidebar = !this.navService.collapseSidebar
     if (!this.checkSidebar) {
       this.menuService.toggleSidebar();
     }
     // if (!this.navService.collapseSidebar) {
     //   window.location.reload(); // Refresh the current page
     // }
    // this.checkSidebar=true;
   }
   collapseSidebar1(){
     this.navService.collapseSidebar = !this.navService.collapseSidebar
     console.log(this.checkSidebar);
     if (this.checkSidebar) {
       this.menuService.toggleSidebar();
     }
     //this.checkSidebar=false;
   }

 //   toggletNavActive() {
 //  this.checkSidebar=!this.checkSidebar
 //     console.log(this.checkSidebar);
 //   }

  toggleMenu(){
   this.isMenuOpen=!this.isMenuOpen;
  }

@HostListener('window:scroll')

onWindowScroll() {

const scrollY = window.scrollY;
if (this.blueheader) {
const element = this.blueheader.nativeElement;
console.log(element);

if (scrollY >= 10) {

element.classList.remove('bluebar_expand');
console.log(  element.classList.remove('bluebar_expand'));


element.classList.add('bluebar_collapse');
console.log( element.classList.add('bluebar_collapse'));


} else {

element.classList.remove('bluebar_collapse');

element.classList.add('bluebar_expand');

}

}

}

}

