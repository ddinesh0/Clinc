import { HostListener, Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NavserviceService {
  public screenWidth: any
	public collapseSidebar: boolean = true;
//	public fullScreen = false;

	constructor(private router:Router) {
		this.onResize();
		if (this.screenWidth < 991) {
			this.collapseSidebar = true;
			console.log(this.collapseSidebar);
			
		}

	}

	// Windows width
	@HostListener('window:resize', ['$event'])
	onResize(event?: undefined) {
		this.screenWidth = window.innerWidth;
	}


}
