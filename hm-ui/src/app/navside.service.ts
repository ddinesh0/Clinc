import { HostListener, Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NavsideService {

  public screenWidth:any;
  public collopse:boolean=true;
  public fullscreen = false;

  constructor( private router:Router) {

    this.onResize();
    if(this.screenWidth<991){
      this.collopse=true
    }
   }
@HostListener('window:resize',['$event'])
   onResize(event?: any){
    this.screenWidth=window.innerWidth;
   }
}
