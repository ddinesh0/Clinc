import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { Patient } from '../../patient';
import { PatientService } from 'src/app/patient.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../../doctor.service';
import { NavserviceService } from 'src/app/navservice.service';
import { MenuserviceService } from 'src/app/menuservice.service';
import { Appointment } from 'src/app/appointment';
import { AppointmentService } from 'src/app/appointment.service';

@Component({
  selector: 'app-patientdashboard',
  templateUrl: './patientdashboard.component.html',
  styleUrls: ['./patientdashboard.component.css']
})
export class PatientdashboardComponent implements OnInit{



  collapses: boolean=true;
  isDropdownOpen:boolean=false
  patient:Patient=new Patient();
  isMenuOpen: boolean=false;

  isScrolled = false;
  id: any;
Patient: any;
searchText: string='';
  filteredItems: any;
  lastValue: any;
  counterMap: { [moduleName: number]: number } = {};
  timers: any;
checkSidebar: any;
value:any;
pat:any;
appointment: Appointment=new Appointment();
  aid: number;

  constructor(private patientservice:PatientService,private router:Router,private route:ActivatedRoute ,private doctorservice:DoctorService,
    public navService:NavserviceService,public menuService:MenuserviceService,public appointmentservice:AppointmentService){}

  @ViewChild('blueheader') blueheader!: ElementRef<HTMLElement>;

ngOnInit(): void {

this.pat=JSON.parse(this.patientservice.getprofile());
this.value=this.pat.name;

 console.log(this.value);

  // const storedValue = localStorage.getItem('name');
  //   this.value = storedValue || '';

  //   const navigation = this.router.getCurrentNavigation();
  //   if (navigation && navigation.extras && navigation.extras.state) {
  //     const state = navigation.extras.state;
  //     this.value = state?.['name'] || '';
  //     console.log(this.value);
  //     localStorage.setItem('name', this.value);
  //   }

  this.menuService.isMenuOpen$.subscribe(isOpen => {

    this.isMenuOpen = isOpen;
  });

  this.doctorservice.getview().subscribe(
    (data: any) => {
      // this.Patient = data;
      this.filteredItems = data;
      const lastIndex = this.filteredItems.length;
      console.log(lastIndex);

      this.lastValue = lastIndex;
      console.log(this.lastValue);

      this.startTimer(this.lastValue); // Pass the lastValue to the startTimer function
    }
  );

  this.route.params.subscribe(params => {
    console.log(params['id']);

    this.patientservice.getbypatientid(this.pat.id).subscribe(data => {
      console.log(data);

      this.Patient = data;
    }, error => console.log(error));
  });


this.onWindowScroll()


}

startTimer(moduleName: any) {
  const lastIndex = this.filteredItems.length ;
  this.lastValue = lastIndex;

  if (this.lastValue === moduleName) {
    this.counterMap[moduleName] = 0; // Initialize the counterMap value for moduleName to 0

    const timer = setInterval(() => {
      if (this.counterMap[moduleName] < moduleName) {
        this.counterMap[moduleName]++;
      } else {
        clearInterval(timer);
      }
    }, 100); // Adjust the interval as per your requirements

    this.timers[moduleName] = timer;
  }
}



OnsearchtextEntered(searchvalue:string){
  this.searchText=searchvalue;
  console.log(this.searchText);

}

profile(){
  this.router.navigate(['/docprofile'])
}

logout(): void {
  this.patientservice.logout();
}


 collopse(){
  this.collapses=!this.collapses
  console.log(this.collapses);

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
toggleDropdown() {
  this.isDropdownOpen = !this.isDropdownOpen;
}
app() {
  this.router.navigate(['/myappoint'])

}

createapp(){
  // const data= {
  //    "id":2,
  //    "age":20,
  //    "dates":"20/05/2023",
  //    "disease":"fever",
  //    "patient":{
  //      "patientId":2
  //    }
  //  }
   this.appointmentservice.createapp(this.appointment,this.pat.id,this.pat.id).subscribe((data:any)=>{
     console.log(this.pat.id)
     if(confirm("added sucessfull"))
     this.router.navigate(["patientdash"])
   })


 }
}
