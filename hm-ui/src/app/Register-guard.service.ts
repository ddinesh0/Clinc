import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterGuardService implements CanActivate{

  constructor(private authservice:AuthService,private router:Router){

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {
   if(this.authservice.IsAuthenticated()){
    return true;
   }else{
    window.alert("you are not allow to acess this page");
    this.router.navigate(['welcomePage']);
    return false;

   }
  }
}
